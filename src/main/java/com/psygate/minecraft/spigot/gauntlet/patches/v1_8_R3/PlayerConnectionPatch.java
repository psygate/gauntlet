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

package com.psygate.minecraft.spigot.gauntlet.patches.v1_8_R3;

import com.psygate.minecraft.spigot.gauntlet.PacketManager;
import com.psygate.minecraft.spigot.gauntlet.connection.packets.IPacketWrapper;
import com.psygate.minecraft.spigot.gauntlet.connection.packets.PacketWrapperManager;
import com.psygate.minecraft.spigot.gauntlet.patches.Patch;
import com.psygate.minecraft.spigot.gauntlet.patches.annotations.InsertionMethod;
import com.psygate.minecraft.spigot.gauntlet.patches.annotations.ReplacementMethod;
import javassist.*;
import net.minecraft.server.v1_8_R3.*;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by psygate on 09.07.2016.
 */
public class PlayerConnectionPatch implements Patch {
    private final static Logger LOG = Logger.getLogger(PlayerConnectionPatch.class.getName());
    CtClass packet;

    @Override
    public void run(ClassPool pool) throws NotFoundException, CannotCompileException {
        packet = pool.get("net.minecraft.server.v1_8_R3.Packet");
        CtClass clazz = pool.get("net.minecraft.server.v1_8_R3.PlayerConnection");
        CtClass local = pool.get(PlayerConnectionPatch.class.getName());

        for (CtMethod localmethod : local.getDeclaredMethods()) {
            if (!localmethod.hasAnnotation(ReplacementMethod.class)) {
                LOG.info("Skipping method: " + localmethod.getName());
            } else {
                LOG.info("Inserting method " + localmethod.getName() + " into " + clazz.getName());
                CtMethod original = clazz.getDeclaredMethod(localmethod.getName(), localmethod.getParameterTypes());
                clazz.removeMethod(original);
                original.setName("original_" + original.getName());
                CtMethod patchin = CtNewMethod.copy(localmethod, clazz, new ClassMap());

                clazz.addMethod(patchin);
                LOG.info("Inserted method " + localmethod.getName() + " into " + clazz.getName());
                clazz.addMethod(original);
            }

            if (localmethod.hasAnnotation(InsertionMethod.class)) {
                clazz.addMethod(CtNewMethod.copy(localmethod, clazz, new ClassMap()));
            }
        }

        //Find all packet methods
        for (CtMethod patch : clazz.getDeclaredMethods()) {
            if (Arrays.stream(patch.getParameterTypes()).filter(this::ispacket).findAny().isPresent()) {

            }
        }

        clazz.toClass();
    }

    private boolean ispacket(CtClass clazz) {
        try {
            return clazz.subtypeOf(packet);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @ReplacementMethod
    public void sendPacket(Packet packet) {
        IPacketWrapper wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
//                System.out.println("Sending: " + wrapped);
                original_sendPacket((Packet) wrapped.unwrap());
            }
        } else {
            original_sendPacket(packet);
        }
    }

    public void original_sendPacket(Packet packet) {

    }

//    public <T> void packetCallProxy(WrappedClass<T> call, T packet) {
//        IPacketWrapper<PacketPlayInSteerVehicle> wrapped = PacketWrapperManager.getInstance().wrap(packet);
//        if (wrapped != null) {
//            PacketManager.getInstance().call(wrapped);
//
//            if (!wrapped.isCancelled()) {
//                original_a(wrapped.unwrap());
//            }
//        } else {
//            original_a(packet);
//        }
//    }

    @ReplacementMethod
    public void a(PacketPlayInSteerVehicle packet) {
        IPacketWrapper<PacketPlayInSteerVehicle> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInFlying packet) {
        IPacketWrapper<PacketPlayInFlying> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInBlockDig packet) {
        IPacketWrapper<PacketPlayInBlockDig> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInBlockPlace packet) {
        IPacketWrapper<PacketPlayInBlockPlace> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInSpectate packet) {
        IPacketWrapper<PacketPlayInBlockPlace> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInResourcePackStatus packet) {
        IPacketWrapper<PacketPlayInResourcePackStatus> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInHeldItemSlot packet) {
        IPacketWrapper<PacketPlayInHeldItemSlot> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInChat packet) {
        IPacketWrapper<PacketPlayInChat> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInArmAnimation packet) {
        IPacketWrapper<PacketPlayInArmAnimation> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInEntityAction packet) {
        IPacketWrapper<PacketPlayInEntityAction> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInUseEntity packet) {
        IPacketWrapper<PacketPlayInUseEntity> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInClientCommand packet) {
        IPacketWrapper<PacketPlayInClientCommand> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInCloseWindow packet) {
        IPacketWrapper<PacketPlayInCloseWindow> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInWindowClick packet) {
        IPacketWrapper<PacketPlayInWindowClick> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInEnchantItem packet) {
        IPacketWrapper<PacketPlayInEnchantItem> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInSetCreativeSlot packet) {
        IPacketWrapper<PacketPlayInSetCreativeSlot> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInTransaction packet) {
        IPacketWrapper<PacketPlayInTransaction> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInUpdateSign packet) {
        IPacketWrapper<PacketPlayInUpdateSign> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInKeepAlive packet) {
        IPacketWrapper<PacketPlayInKeepAlive> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInAbilities packet) {
        IPacketWrapper<PacketPlayInAbilities> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInTabComplete packet) {
        IPacketWrapper<PacketPlayInTabComplete> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInSettings packet) {
        IPacketWrapper<PacketPlayInSettings> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    @ReplacementMethod
    public void a(PacketPlayInCustomPayload packet) {
        IPacketWrapper<PacketPlayInCustomPayload> wrapped = PacketWrapperManager.getInstance().wrap(packet);
        if (wrapped != null) {
            PacketManager.getInstance().call(wrapped);

            if (!wrapped.isCancelled()) {
                original_a(wrapped.unwrap());
            }
        } else {
            original_a(packet);
        }
    }

    //////////////////////////////////////

    public void original_a(PacketPlayInSteerVehicle packetplayinsteervehicle) {

    }

    public void original_a(PacketPlayInFlying packetplayinflying) {

    }

    public void original_a(PacketPlayInBlockDig packetplayinblockdig) {

    }

    public void original_a(PacketPlayInBlockPlace packetplayinblockplace) {

    }

    public void original_a(PacketPlayInSpectate packetplayinspectate) {

    }

    public void original_a(PacketPlayInResourcePackStatus packetplayinresourcepackstatus) {

    }

    public void original_a(IChatBaseComponent ichatbasecomponent) {

    }

    public void original_a(PacketPlayInHeldItemSlot packetplayinhelditemslot) {

    }

    public void original_a(PacketPlayInChat packetplayinchat) {

    }

    public void original_a(PacketPlayInArmAnimation packetplayinarmanimation) {

    }

    public void original_a(PacketPlayInEntityAction packetplayinentityaction) {

    }

    public void original_a(PacketPlayInUseEntity packetplayinuseentity) {

    }

    public void original_a(PacketPlayInClientCommand packetplayinclientcommand) {

    }

    public void original_a(PacketPlayInCloseWindow packetplayinclosewindow) {

    }

    public void original_a(PacketPlayInWindowClick packetplayinwindowclick) {

    }

    public void original_a(PacketPlayInEnchantItem packetplayinenchantitem) {

    }

    public void original_a(PacketPlayInSetCreativeSlot packetplayinsetcreativeslot) {

    }

    public void original_a(PacketPlayInTransaction packetplayintransaction) {

    }

    public void original_a(PacketPlayInUpdateSign packetplayinupdatesign) {

    }

    public void original_a(PacketPlayInKeepAlive packetplayinkeepalive) {

    }

    public void original_a(PacketPlayInAbilities packetplayinabilities) {

    }

    public void original_a(PacketPlayInTabComplete packetplayintabcomplete) {

    }

    public void original_a(PacketPlayInSettings packetplayinsettings) {

    }

    public void original_a(PacketPlayInCustomPayload packetplayincustompayload) {

    }
}
