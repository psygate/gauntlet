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

package com.psygate.minecraft.spigot.gauntlet.connection.packets;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by psygate on 09.07.2016.
 */
public class PacketWrapperManager {
    private final static Logger LOG = Logger.getLogger(PacketWrapperManager.class.getName());
    private static PacketWrapperManager instance;

    private PacketWrapperManager() {
    }

    public static PacketWrapperManager getInstance() {
        if (instance == null) {
            instance = new PacketWrapperManager();
        }

        return instance;
    }

    private Map<Class<?>, Function<Object, IPacketWrapper>> generators = new HashMap<>();

    private Function<Object, IPacketWrapper> getGenerator(Class<?> clazz) {
        return generators.computeIfAbsent(clazz, objclass -> {
            String clazzName = objclass.getName();
            String preclassname = clazzName.replace("net.minecraft.server", "com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers") + "Wrapper";
            String gauntletClassName = preclassname.replace("$", ".");
            Class<? extends IPacketWrapper> wrapperclass = null;
            try {
                wrapperclass = (Class<? extends IPacketWrapper>) Class.forName(gauntletClassName);
            } catch (ClassNotFoundException e) {
                LOG.info("No wrapper class found for " + clazz);
                return (obj) -> null;
            }
            try {
                Constructor<? extends IPacketWrapper> constr = wrapperclass.getConstructor(objclass);
                MethodHandle constructorInvoke = MethodHandles.lookup().unreflectConstructor(constr);
                return (objin) -> {
                    try {
                        return (IPacketWrapper) constructorInvoke.invoke(objin);
                    } catch (Throwable throwable) {
                        throw new RuntimeException(throwable);
                    }
                };
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Failed to wrap packet: " + clazz, e);
                return (objin) -> null;
            }
        });
    }

    public IPacketWrapper wrap(Object packet) {
        return getGenerator(packet.getClass()).apply(packet);
    }
}
