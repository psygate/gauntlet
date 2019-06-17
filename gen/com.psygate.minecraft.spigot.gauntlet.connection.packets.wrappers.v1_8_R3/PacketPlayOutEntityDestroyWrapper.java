package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutEntityDestroyWrapper implements IPacketPlayOutEntityDestroyWrapper {
private final static java.lang.reflect.Field reflect_A;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy.class.getDeclaredField("a");
reflect_A.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy packet;

public PacketPlayOutEntityDestroyWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy unwrap() {return packet;}
public int[] getA() {
try {
return (int[]) reflect_A.get(packet);
 } catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setA(int[] param) {
try {
reflect_A.set(packet, param);
 } catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutEntityDestroy[" + getA() + "]";
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