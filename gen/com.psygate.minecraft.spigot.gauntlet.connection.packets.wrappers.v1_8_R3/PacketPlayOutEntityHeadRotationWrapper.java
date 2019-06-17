package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutEntityHeadRotationWrapper implements IPacketPlayOutEntityHeadRotationWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation.class.getDeclaredField("b");
reflect_B.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation packet;

public PacketPlayOutEntityHeadRotationWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation unwrap() {return packet;}
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
public byte getB() {
try {
return reflect_B.getByte(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setB(byte param) {
try {
reflect_B.setByte(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutEntityHeadRotation[" + getA()+", "+getB() + "]";
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