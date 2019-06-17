package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutExperienceWrapper implements IPacketPlayOutExperienceWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutExperience.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayOutExperience.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayOutExperience.class.getDeclaredField("c");
reflect_C.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutExperience packet;

public PacketPlayOutExperienceWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutExperience packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutExperience unwrap() {return packet;}
public float getA() {
try {
return reflect_A.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setA(float param) {
try {
reflect_A.setFloat(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getB() {
try {
return reflect_B.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setB(int param) {
try {
reflect_B.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getC() {
try {
return reflect_C.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setC(int param) {
try {
reflect_C.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutExperience[" + getA()+", "+getB()+", "+getC() + "]";
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