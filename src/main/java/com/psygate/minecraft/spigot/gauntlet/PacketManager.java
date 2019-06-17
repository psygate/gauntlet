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

package com.psygate.minecraft.spigot.gauntlet;


import com.psygate.minecraft.spigot.gauntlet.connection.listeners.Listener;
import com.psygate.minecraft.spigot.gauntlet.connection.listeners.PacketListener;
import com.psygate.minecraft.spigot.gauntlet.connection.packets.IPacketWrapper;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by psygate on 09.07.2016.
 */
@SuppressWarnings("unchecked")
public class PacketManager {
    private final static Logger LOG = Logger.getLogger(PacketManager.class.getName());
    private static PacketManager instance;

    private PacketManager() {
    }

    public static PacketManager getInstance() {
        if (instance == null) {
            instance = new PacketManager();
        }
        return instance;
    }

    private final Map<Class, PriorityQueue<InvokationWrapper>> listeners = new HashMap<>();
    private final Map<Class, Class> interfaceExtractionFunctions = new HashMap<>();

    private final PriorityQueue<InvokationWrapper> empty = new PriorityQueue<>();

    public void registerListener(Listener li) throws IllegalAccessException {
        for (Method method : li.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(PacketListener.class) != null) {
                if (method.getParameters().length != 1) {
                    LOG.warning("Packet listener method declared, but parameter mismatch: " + method);
                    continue;
                } else {
                    Parameter param = method.getParameters()[0];
                    if (!IPacketWrapper.class.isAssignableFrom(param.getType())) {
                        if (method.getParameters().length != 1) {
                            LOG.warning("Packet listener method declared, but parameter type mismatch: " + method + " " + param);
                            continue;
                        }
                    }

                    method.setAccessible(true);

                    PacketListener anot = method.getAnnotation(PacketListener.class);
                    int priority = anot.priority();
                    listeners.computeIfAbsent(param.getType(), aClass -> new PriorityQueue<>());
                    listeners.get(param.getType()).add(new InvokationWrapper(method, li, priority));
                    LOG.info("Registered " + method + " as listener for " + param.getType() + " packets.");
                }
            }
        }
    }

    public void call(IPacketWrapper wrapper) {
        LOG.finest(() -> "Calling listeners for " + wrapper.getClass());
        Class<?> ifc = interfaceExtractionFunctions.computeIfAbsent(wrapper.getClass(), aClass -> {
            List<Class> interfaces = Arrays.asList(aClass.getInterfaces()).stream()
                    .filter(i -> IPacketWrapper.class.isAssignableFrom(i))
                    .distinct()
                    .collect(Collectors.toList());

            if (interfaces.size() > 1) {
                LOG.severe(aClass + " implements more than one IPacketWrapper interface. Call resolution failed. " + interfaces);
                return null;
            } else {
                return interfaces.get(0);
            }
        });

        listeners.getOrDefault(ifc, empty).forEach(i -> {
            try {
                i.invoke(wrapper);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private class InvokationWrapper implements Comparable<InvokationWrapper> {
        private MethodHandle call;
        private Listener callon;
        private int priority;

        public InvokationWrapper(Method call, Listener callon, int priority) throws IllegalAccessException {
            this.call = MethodHandles.lookup().unreflect(call).bindTo(callon);
            this.callon = callon;
            this.priority = priority;
        }


        public Listener getCallon() {
            return callon;
        }

        public void setCallon(Listener callon) {
            this.callon = callon;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(InvokationWrapper o) {
            return Integer.compare(priority, o.getPriority());
        }

        public void invoke(IPacketWrapper data) throws Throwable {
            call.invoke(data);
        }
    }
}
