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

package com.psygate.minecraft.spigot.gauntlet.generation;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.util.Objects;

/**
 * Created by psygate on 09.07.2016.
 */
public class PrimitiveField {
    private final static CtClass clong, cint, cfloat, cchar, cdouble, cshort, cbyte, cboolean;

    static {
        try {
            clong = ClassPool.getDefault().getCtClass(long.class.getName());
            cint = ClassPool.getDefault().getCtClass(int.class.getName());
            cfloat = ClassPool.getDefault().getCtClass(float.class.getName());
            cchar = ClassPool.getDefault().getCtClass(char.class.getName());
            cdouble = ClassPool.getDefault().getCtClass(double.class.getName());
            cshort = ClassPool.getDefault().getCtClass(short.class.getName());
            cbyte = ClassPool.getDefault().getCtClass(byte.class.getName());
            cboolean = ClassPool.getDefault().getCtClass(boolean.class.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CtField field;
    private String capitalizedFieldName;

    public PrimitiveField(CtField field) {
        this.field = Objects.requireNonNull(field, () -> "Field cannot be null.");
        capitalizedFieldName = capitalize(field.getName());
    }

    public String generateReflectionAccessor() {
        return "private final static java.lang.reflect.Field reflect_" + capitalizedFieldName + ";\n";
    }

    public String generateInitializer() {
        return "reflect_" + capitalizedFieldName + " = " + field.getDeclaringClass().getName() + ".class.getDeclaredField(\"" + field.getName() + "\");\n" +
                "reflect_" + capitalizedFieldName + ".setAccessible(true);";
    }

    public String generateGetter() throws NotFoundException {
        return "public " + generateGetterSignature() + " {\n" +
                "try {\n" +
                genGetterReturn() +
//                "return reflect_" + capitalizedFieldName + ".get(packet);" +
                "} catch(Exception e) {\n" +
                "throw new RuntimeException(e);\n" +
                "}" +
                "\n}";
    }

    public String generateSetter() throws NotFoundException {
        return "public void " + generateSetterName() + "(" + field.getType().getName() + " param) {\n" +
                "try {\n" +
                genSetterReturn() +
//                "return reflect_" + capitalizedFieldName + ".get(packet);" +
                "} catch(Exception e) {\n" +
                "throw new RuntimeException(e);\n" +
                "}" +
                "\n}";
    }

    private String genSetterReturn() throws NotFoundException {
        if (field.getType().equals(clong)) {
            return "reflect_" + capitalizedFieldName + ".setLong(packet, param);\n";
        } else if (field.getType().equals(cint)) {
            return "reflect_" + capitalizedFieldName + ".setInt(packet, param);\n";
        } else if (field.getType().equals(cchar)) {
            return "reflect_" + capitalizedFieldName + ".setChar(packet, param);\n";
        } else if (field.getType().equals(cdouble)) {
            return "reflect_" + capitalizedFieldName + ".setDouble(packet, param);\n";
        } else if (field.getType().equals(cshort)) {
            return "reflect_" + capitalizedFieldName + ".setShort(packet, param);\n";
        } else if (field.getType().equals(cbyte)) {
            return "reflect_" + capitalizedFieldName + ".setByte(packet, param);\n";
        } else if (field.getType().equals(cboolean)) {
            return "reflect_" + capitalizedFieldName + ".setBoolean(packet, param);\n";
        } else if (field.getType().equals(cfloat)) {
            return "reflect_" + capitalizedFieldName + ".setFloat(packet, param);\n";
        } else {
            return "reflect_" + capitalizedFieldName + ".set(packet, param);\n ";
        }
    }

    private String genGetterReturn() throws NotFoundException {
        if (field.getType().equals(clong)) {
            return "return reflect_" + capitalizedFieldName + ".getLong(packet);\n";
        } else if (field.getType().equals(cint)) {
            return "return reflect_" + capitalizedFieldName + ".getInt(packet);\n";
        } else if (field.getType().equals(cchar)) {
            return "return reflect_" + capitalizedFieldName + ".getChar(packet);\n";
        } else if (field.getType().equals(cdouble)) {
            return "return reflect_" + capitalizedFieldName + ".getDouble(packet);\n";
        } else if (field.getType().equals(cshort)) {
            return "return reflect_" + capitalizedFieldName + ".getShort(packet);\n";
        } else if (field.getType().equals(cbyte)) {
            return "return reflect_" + capitalizedFieldName + ".getByte(packet);\n";
        } else if (field.getType().equals(cboolean)) {
            return "return reflect_" + capitalizedFieldName + ".getBoolean(packet);\n";
        } else if (field.getType().equals(cfloat)) {
            return "return reflect_" + capitalizedFieldName + ".getFloat(packet);\n";
        } else {
            return "return (" + field.getType().getName() + ") reflect_" + capitalizedFieldName + ".get(packet);\n ";
        }

    }

    private static String capitalize(String name) {
        if (name.length() > 1) {
            return Character.toUpperCase(name.charAt(0)) + name.substring(1);
        } else {
            return String.valueOf(Character.toUpperCase(name.charAt(0)));
        }
    }

    public String generateGetterSignature() throws NotFoundException {
        return field.getType().getName() + " " + generateGetterName() + "()";
    }

    public String generateGetterName() throws NotFoundException {
        return "get" + capitalizedFieldName;
    }

    public String generateSetterName() {
        return "set" + capitalizedFieldName;
    }

    public String generateSetterSignature() throws NotFoundException {
        return "void " + generateSetterName() + "(" + field.getType().getName() + " param)";
    }
}
