package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketStatusOutPongWrapper implements IPacketStatusOutPongWrapper {
private final static java.lang.reflect.Field reflect_A;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketStatusOutPong.class.getDeclaredField("a");
reflect_A.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketStatusOutPong packet;

public PacketStatusOutPongWrapper(net.minecraft.server.v1_8_R3.PacketStatusOutPong packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketStatusOutPong unwrap() {return packet;}
public long getA() {
try {
return reflect_A.getLong(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setA(long param) {
try {
reflect_A.setLong(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketStatusOutPong[" + getA() + "]";
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