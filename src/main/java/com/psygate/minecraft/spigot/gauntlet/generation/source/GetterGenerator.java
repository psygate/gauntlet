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

/**
 * Created by psygate on 10.07.2016.
 */
public class GetterGenerator extends MethodGenerator {
    private Class<?> type;

    public GetterGenerator(Class<?> type) {
        this.type = type;
    }

    public void generateReflectionGetter(JTryBlock appendTo, JFieldVar reflectionField, JFieldVar packetField) {
        if (type.isPrimitive() && !type.isArray()) {
            appendTo.body()._return(reflectionField.invoke("get" + capitalize(type.getName())).arg(packetField));
        }
    }

    private String capitalize(String name) {
        if (name.length() == 1) {
            return String.valueOf(Character.toUpperCase(name.charAt(0)));
        } else {
            return String.valueOf(Character.toUpperCase(name.charAt(0))) + name.substring(1);
        }
    }

}
