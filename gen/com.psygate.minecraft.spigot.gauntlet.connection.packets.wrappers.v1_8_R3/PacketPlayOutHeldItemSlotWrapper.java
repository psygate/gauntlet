package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutHeldItemSlotWrapper implements IPacketPlayOutHeldItemSlotWrapper {
private final static java.lang.reflect.Field reflect_A;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutHeldItemSlot.class.getDeclaredField("a");
reflect_A.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutHeldItemSlot packet;

public PacketPlayOutHeldItemSlotWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutHeldItemSlot packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutHeldItemSlot unwrap() {return packet;}
public int getA() {
try {
return reflect_A.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setA(int param) {
try {
reflect_A.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutHeldItemSlot[" + getA() + "]";
    }
private boolean sealed = false, cancelled = false;
    public boolean isSealed() {
        return sealed;
    }

    public void seal() {
        sealed = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }}