package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInFlyingWrapper implements IPacketPlayInFlyingWrapper {
private final static java.lang.reflect.Field reflect_X;
private final static java.lang.reflect.Field reflect_Y;
private final static java.lang.reflect.Field reflect_Z;
private final static java.lang.reflect.Field reflect_Yaw;
private final static java.lang.reflect.Field reflect_Pitch;
private final static java.lang.reflect.Field reflect_F;
private final static java.lang.reflect.Field reflect_HasPos;
private final static java.lang.reflect.Field reflect_HasLook;
static {
try {
reflect_X = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("x");
reflect_X.setAccessible(true);reflect_Y = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("y");
reflect_Y.setAccessible(true);reflect_Z = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("z");
reflect_Z.setAccessible(true);reflect_Yaw = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("yaw");
reflect_Yaw.setAccessible(true);reflect_Pitch = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("pitch");
reflect_Pitch.setAccessible(true);reflect_F = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("f");
reflect_F.setAccessible(true);reflect_HasPos = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("hasPos");
reflect_HasPos.setAccessible(true);reflect_HasLook = net.minecraft.server.v1_8_R3.PacketPlayInFlying.class.getDeclaredField("hasLook");
reflect_HasLook.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInFlying packet;

public PacketPlayInFlyingWrapper(net.minecraft.server.v1_8_R3.PacketPlayInFlying packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInFlying unwrap() {return packet;}
public double getX() {
try {
return reflect_X.getDouble(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setX(double param) {
try {
reflect_X.setDouble(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public double getY() {
try {
return reflect_Y.getDouble(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setY(double param) {
try {
reflect_Y.setDouble(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public double getZ() {
try {
return reflect_Z.getDouble(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setZ(double param) {
try {
reflect_Z.setDouble(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public float getYaw() {
try {
return reflect_Yaw.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setYaw(float param) {
try {
reflect_Yaw.setFloat(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public float getPitch() {
try {
return reflect_Pitch.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setPitch(float param) {
try {
reflect_Pitch.setFloat(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getF() {
try {
return reflect_F.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setF(boolean param) {
try {
reflect_F.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getHasPos() {
try {
return reflect_HasPos.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setHasPos(boolean param) {
try {
reflect_HasPos.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getHasLook() {
try {
return reflect_HasLook.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setHasLook(boolean param) {
try {
reflect_HasLook.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayInFlying[" + getX()+", "+getY()+", "+getZ()+", "+getYaw()+", "+getPitch()+", "+getF()+", "+getHasPos()+", "+getHasLook() + "]";
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