package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutSpawnEntityWrapper implements IPacketPlayOutSpawnEntityWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
private final static java.lang.reflect.Field reflect_D;
private final static java.lang.reflect.Field reflect_E;
private final static java.lang.reflect.Field reflect_F;
private final static java.lang.reflect.Field reflect_G;
private final static java.lang.reflect.Field reflect_H;
private final static java.lang.reflect.Field reflect_I;
private final static java.lang.reflect.Field reflect_J;
private final static java.lang.reflect.Field reflect_K;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("c");
reflect_C.setAccessible(true);reflect_D = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("d");
reflect_D.setAccessible(true);reflect_E = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("e");
reflect_E.setAccessible(true);reflect_F = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("f");
reflect_F.setAccessible(true);reflect_G = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("g");
reflect_G.setAccessible(true);reflect_H = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("h");
reflect_H.setAccessible(true);reflect_I = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("i");
reflect_I.setAccessible(true);reflect_J = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("j");
reflect_J.setAccessible(true);reflect_K = net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity.class.getDeclaredField("k");
reflect_K.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity packet;

public PacketPlayOutSpawnEntityWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity unwrap() {return packet;}
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
public int getF() {
try {
return reflect_F.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setF(int param) {
try {
reflect_F.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getG() {
try {
return reflect_G.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setG(int param) {
try {
reflect_G.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getH() {
try {
return reflect_H.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setH(int param) {
try {
reflect_H.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getI() {
try {
return reflect_I.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setI(int param) {
try {
reflect_I.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getJ() {
try {
return reflect_J.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setJ(int param) {
try {
reflect_J.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public int getK() {
try {
return reflect_K.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setK(int param) {
try {
reflect_K.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutSpawnEntity[" + getA()+", "+getB()+", "+getC()+", "+getD()+", "+getE()+", "+getF()+", "+getG()+", "+getH()+", "+getI()+", "+getJ()+", "+getK() + "]";
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