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

import com.psygate.minecraft.spigot.gauntlet.generation.source.ClassGenerator;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * Created by psygate on 09.07.2016.
 */
public class PacketWrapperGenerator {
    private final static Logger LOG = Logger.getLogger(PacketWrapperGenerator.class.getName());
    private final static String searchSpace = "net.minecraft.server.v1_8_R3";
    private final static String targetPackage = "com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3";

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass packetBaseClass = pool.getCtClass("net.minecraft.server.v1_8_R3.Packet");

        JarFile spigotjar = new JarFile("run/spigot-1.8.8.jar");
        Enumeration<JarEntry> entryit = spigotjar.entries();

        ClassGenerator gen = new ClassGenerator();

        while (entryit.hasMoreElements()) {
            JarEntry entry = entryit.nextElement();
            if (!entry.getName().endsWith(".class")) {
                continue;
            }
            try (InputStream entryin = spigotjar.getInputStream(entry)) {
                CtClass clazz = pool.makeClass(entryin);
                if (clazz.getPackageName().startsWith(searchSpace)
                        && clazz.subtypeOf(packetBaseClass)
                        && !clazz.getName().equals(packetBaseClass.getName())
                        && !clazz.getName().contains("$")) {

                    gen.addClass(clazz, targetPackage);
//                    if (onlyPrimitiveFields(clazz)) {
//                        LOG.info("Found primitive packet class. " + clazz.getName());
//                        PrimitivePacketWrapperClassGenerator gen = new PrimitivePacketWrapperClassGenerator(clazz, targetPackage);
//                        gen.persist(new File("gen"));
//                        PrimitivePacketWrapperInterfaceGenerator igen = new PrimitivePacketWrapperInterfaceGenerator(clazz, targetPackage);
//                        igen.persist(new File("gen"));
//                    } else {
//                        LOG.warning("Unable to generateReflectionGetter " + clazz.getName());
//                    }
                }
            }
        }

        gen.finish();

    }

    private static String generatePrimitiveClass(CtClass packetClass) {
        String className = packetClass.getSimpleName() + "Wrapper";
        StringBuilder out = new StringBuilder();

        out.append("package " + targetPackage + ";");
        out.append("\n");
        out.append("//Gauntlet generated wrapper class.\n");
        out.append("public class " + className + " {\n");
        out.append("private " + packetClass.getName() + " packet;\n\n");
        out.append("public " + className + "(" + packetClass.getName() + " packet) {\n");
        out.append("this.packet = Objects.requireNonNull(packet, () -> \"Provided packet for wrapper cannot be null.\");\n");
        out.append("}");

        return out.toString();
    }

    private static boolean onlyPrimitiveFields(CtClass packetClass) throws NotFoundException {
        LOG.info("Checking for primitives: " + packetClass.getName());
        for (CtField field : packetClass.getDeclaredFields()) {
            if (field.getType().isPrimitive() || (field.getType().isArray() && field.getType().getComponentType().isPrimitive())) {

            } else {
                LOG.fine("Not a primitive: " + field.getType().getName());
                return false;
            }
            LOG.info("Primitive: " + field.getType());
        }

        LOG.info("No complex fields found on " + packetClass.getName());

        return true;
    }
}
