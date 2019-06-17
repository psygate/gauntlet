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
public class PrimitivePacketWrapperInterfaceGenerator {
    private CtClass target;
    private String className;
    private String targetPackage;
    private String classSource;

    public PrimitivePacketWrapperInterfaceGenerator(CtClass target, String targetPackage) {
        this.target = target;
        className = "I" + target.getSimpleName() + "Wrapper";
        this.targetPackage = targetPackage;
    }

    public void generate() throws NotFoundException {
        StringBuilder out = new StringBuilder();

        List<PrimitiveField> fields = Arrays.stream(target.getDeclaredFields()).map(PrimitiveField::new).collect(Collectors.toList());

        out.append("package " + targetPackage + ";");
        out.append("\n");
        out.append("//Gauntlet generated interface class.\n");
        out.append("public interface " + className + " extends com.psygate.minecraft.spigot.gauntlet.connection.packets.IPacketWrapper {\n");

        for (PrimitiveField field : fields) {
            out.append(field.generateGetterSignature() + ";\n");
            out.append(field.generateSetterSignature() + ";\n");
        }
        out.append("}");
        this.classSource = out.toString();
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
