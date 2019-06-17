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

import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by psygate on 09.07.2016.
 */
public class PrimitivePacketWrapperClassGenerator {
    private CtClass target;
    private String className;
    private String targetPackage;
    private String classSource;

    public PrimitivePacketWrapperClassGenerator(CtClass target, String targetPackage) {
        this.target = target;
        className = target.getSimpleName() + "Wrapper";
        this.targetPackage = targetPackage;
    }

    public void generate() throws NotFoundException {
        StringBuilder out = new StringBuilder();

        List<PrimitiveField> fields = Arrays.stream(target.getDeclaredFields()).map(PrimitiveField::new).collect(Collectors.toList());

        out.append("package " + targetPackage + ";");
        out.append("\n");
        out.append("import java.util.Objects;\n");
        out.append("//Gauntlet generated wrapper class.\n");
        out.append("public class " + className + " implements I" + className + " {\n");
        for (PrimitiveField field : fields) {
            out.append(field.generateReflectionAccessor());
        }
        out.append("static {\ntry {\n");
        for (PrimitiveField field : fields) {
            out.append(field.generateInitializer());
        }
        out.append("} catch(Exception e) {throw new RuntimeException(e);}\n}\n");
        out.append("private " + target.getName() + " packet;\n\n");
        out.append("public " + className + "(" + target.getName() + " packet) {\n");
        out.append("this.packet = Objects.requireNonNull(packet, () -> \"Provided packet for wrapper cannot be null.\");\n");
        out.append("}\n\n");

        out.append("public " + target.getName() + " unwrap() {return packet;}\n");

        for (PrimitiveField field : fields) {
            out.append(field.generateGetter() + "\n");
            out.append(field.generateSetter() + "\n");
        }

        out.append(generateToStringMethod());

        /*
            boolean isSealed();

    void seal();

    boolean isCancelled();

    boolean setCancelled(boolean cancel);
         */

        out.append("private boolean sealed = false, cancelled = false;\n");
        out.append("    public boolean isSealed() {\n" +
                "        return sealed;\n" +
                "    }\n" +
                "\n" +
                "    public void seal() {\n" +
                "        sealed = true;\n" +
                "    }\n" +
                "\n" +
                "    public boolean isCancelled() {\n" +
                "        return cancelled;\n" +
                "    }\n" +
                "\n" +
                "    public void setCancelled(boolean cancelled) {\n" +
                "        this.cancelled = cancelled;\n" +
                "    }");
        this.classSource = out.append("}").toString();
    }

    private String generateToStringMethod() throws NotFoundException {
        if (target.getDeclaredFields().length == 0) {
            return "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"$classname$[]\";\n" +
                    "    }\n".replaceAll("\\$classname\\$", target.getSimpleName());
        }
        String fieldString = "";
        for (CtField field : target.getDeclaredFields()) {
            PrimitiveField f = new PrimitiveField(field);
            if (!"".equals(fieldString)) {
                fieldString += "+\", \"+";
            }
            fieldString += f.generateGetterName() + "()";
        }
        String tostr = "    @Override\n" +
                "    public String toString() {\n" +
                "        return \"$classname$[\" + $getterstr$ + \"]\";\n" +
                "    }\n";


        return tostr.replaceAll("\\$classname\\$", target.getSimpleName()).replaceAll("\\$getterstr\\$", fieldString);
    }


    public void persist(File folder) throws IOException, NotFoundException {
        if (classSource == null) {
            generate();
        }

        File targetFolder = new File(folder, targetPackage.replace("\\.", "/"));
        if (!targetFolder.exists()) {
            targetFolder.mkdirs();
        }

        File targetFile = new File(targetFolder, className + ".java");

        try (FileOutputStream out = new FileOutputStream(targetFile)) {
            out.write(classSource.getBytes(Charset.forName("UTF-8")));
        }
    }
}
