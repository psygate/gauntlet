/*
 *     Copyright (C) 2016 psygate (https://github.com/psygate)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 */

package com.psygate.minecraft.spigot.gauntlet.generation.source;

import com.helger.jcodemodel.*;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by psygate on 10.07.2016.
 */
public class ClassGenerator {
    private final static Logger LOG = Logger.getLogger(ClassGenerator.class.getName());
    private JCodeModel mod = new JCodeModel();
    private Map<Class<?>, MethodGenerator> generatorMap = new HashMap<>();

    public ClassGenerator() {
        for (Class<?> clazz : new Class[]{byte.class, short.class, int.class, long.class, boolean.class, char.class, float.class, double.class}) {
            generatorMap.put(clazz, new GetterGenerator(clazz));
        }
    }

    public void addClass(CtClass clazz, String targetPackage) throws Exception {
        Class<?> actualclass = Class.forName(clazz.getName());
        JDefinedClass jclass = mod._class(targetPackage + "." + clazz.getSimpleName() + "Wrapper");
        String ifacename = jclass._package().name() + ".I" + jclass.name() + "_" + targetPackage.split("\\.")[targetPackage.split("\\.").length - 1];
        JDefinedClass jinterface = mod._class(JMod.PUBLIC, ifacename, EClassType.INTERFACE);

        JFieldVar packetField = jclass.field(JMod.PRIVATE, actualclass, "packet");

        JMethod constr = jclass.constructor(JMod.PUBLIC);
        JVar packetConstrParam = constr.param(actualclass, "packetin");

        constr.body().assign(packetField, packetConstrParam);

        //Generate getters and setters.
        JBlock staticInit = jclass.init();
        JTryBlock staticInitTry = staticInit._try();
        AbstractJClass exp = Objects.requireNonNull(mod.ref(Exception.class));
        JCatchBlock catchexpr = staticInitTry._catch(exp);
        JVar exceptionin = catchexpr.param("exception");
        catchexpr.body()._throw(JExpr._new(mod.ref(RuntimeException.class)).arg(exceptionin));
        for (CtField field : clazz.getDeclaredFields()) {

            if (field.getType().getName().contains("net.minecraft")) {
                LOG.warning("Complex field found " + clazz.getName() + "." + field.getName());
            }

            JFieldVar reflfield = jclass.field(JMod.PRIVATE | JMod.STATIC | JMod.FINAL, Field.class, field.getName());
            staticInitTry.body().assign(reflfield, JExpr.direct(clazz.getName() + ".class.getDeclaredField(\"" + field.getName() + "\")"));

            String fieldTypeName = field.getType().getName().replaceAll("\\$", ".");
            staticInitTry.body()._if(reflfield.invoke("isAccessible").not())._then().add(reflfield.invoke("setAccessible").arg(JExpr.TRUE));
            JMethod getter = jclass.method(JMod.PUBLIC, mod.ref(fieldTypeName), "get" + capitalize(field.getName()));

            jinterface.method(JMod.PUBLIC, mod.ref(field.getType().getName()), "get" + capitalize(field.getName()));

            JTryBlock gettertry = getter.body()._try();
            JCatchBlock gettercatch = gettertry._catch(exp);
            JVar getterexcp = gettercatch.param("exception");

            generatorMap.getOrDefault(getClassFor(field.getType()), new GetterGenerator(getClassFor(field.getType())))
                    .generateReflectionGetter(gettertry, reflfield, packetField);
        }

        jclass._implements(jinterface);
    }

    private Class<?> getClassFor(CtClass type) throws ClassNotFoundException, NotFoundException {
        if (type.isPrimitive() && !type.isArray()) {
            switch (type.getName()) {
                case "byte":
                    return byte.class;
                case "short":
                    return short.class;
                case "int":
                    return int.class;
                case "long":
                    return long.class;
                case "boolean":
                    return boolean.class;
                case "char":
                    return char.class;
                case "float":
                    return float.class;
                case "double":
                    return double.class;
                default:
                    throw new IllegalStateException();
            }

        } else if (type.isArray() && type.getComponentType().isPrimitive()) {
            switch (type.getName()) {
                case "byte[]":
                    return byte[].class;
                case "short[]":
                    return short[].class;
                case "int[]":
                    return int[].class;
                case "long[]":
                    return long[].class;
                case "boolean[]":
                    return boolean[].class;
                case "char[]":
                    return char[].class;
                case "float[]":
                    return float[].class;
                case "double[]":
                    return double[].class;
                default:
                    throw new IllegalStateException();
            }
        } else if (type.isArray()) {
            return Class.forName(type.getComponentType().getName());
        } else {
            return Class.forName(type.getName());
        }
    }

    private String capitalize(String name) {
        if (name.length() == 1) {
            return String.valueOf(Character.toUpperCase(name.charAt(0)));
        } else {
            return String.valueOf(Character.toUpperCase(name.charAt(0))) + name.substring(1);
        }
    }

    public void finish() throws IOException {
//        SingleStreamCodeWriter str = new SingleStreamCodeWriter(System.out);
//        mod.build(str);
        new File("testgen/").mkdirs();
        mod.build(new File("testgen/"));
//        str.close();

    }


}
