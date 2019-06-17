package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutSpawnEntityExperienceOrbWrapper implements IPacketPlayOutSpawnEntityExperienceOrbWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
private final static java.lang.reflect.Field reflect_D;
private final static java.lang.reflect.Field reflect_E;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb.class.getDeclaredField("c");
reflect_C.setAccessible(true);reflect_D = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb.class.getDeclaredField("d");
reflect_D.setAccessible(true);reflect_E = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb.class.getDeclaredField("e");
reflect_E.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb packet;

public PacketPlayOutSpawnEntityExperienceOrbWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityExperienceOrb unwrap() {return packet;}
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
public int getD() {
try {
return reflect_D.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setD(int param) {
try {
reflect_D.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getE() {
try {
return reflect_E.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setE(int param) {
try {
reflect_E.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutSpawnEntityExperienceOrb[" + getA()+", "+getB()+", "+getC()+", "+getD()+", "+getE() + "]";
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