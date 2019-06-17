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
import com.psygate.minecraft.spigot.gauntlet.patches.GrandUnifiedPatcher;
import org.bukkit.craftbukkit.Main;

import java.util.logging.Logger;

//import com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3.IPacketPlayOutWindowDataWrapper;

//import com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.IPacketLoginInStartWrapper;
//import com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.IPacketPlayInCustomPayload;
//import com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.IPacketPlayOutWindowDataWrapper;

/**
 * Created by psygate on 29.05.2016.
 */
public class Gauntlet {
    private final static Logger LOG = Logger.getLogger(Gauntlet.class.getName());

    public static void main(String[] args) throws Throwable {
        GrandUnifiedPatcher.getInstance().init();

        PacketManager.getInstance();

        PacketManager.getInstance().registerListener(new Listener() {
            @PacketListener
            public void onWindowOut(com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3.IPacketPlayOutWindowDataWrapper wrapper) {
                switch (wrapper.getB()) {
                    case 0:
                    case 1:
                    case 2:
                        wrapper.setC(wrapper.getB() * 10 + 10);
                        break;
                    case 3:
                        wrapper.setC((int) System.nanoTime());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        wrapper.setC(-1);
                        break;
                }
            }
        });

        Main.main(args);
    }
}
