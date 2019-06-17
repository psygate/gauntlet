package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayOutAbilitiesWrapper implements IPacketPlayOutAbilitiesWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
private final static java.lang.reflect.Field reflect_D;
private final static java.lang.reflect.Field reflect_E;
private final static java.lang.reflect.Field reflect_F;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("c");
reflect_C.setAccessible(true);reflect_D = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("d");
reflect_D.setAccessible(true);reflect_E = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("e");
reflect_E.setAccessible(true);reflect_F = net.minecraft.server.v1_8_R3.PacketPlayOutAbilities.class.getDeclaredField("f");
reflect_F.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayOutAbilities packet;

public PacketPlayOutAbilitiesWrapper(net.minecraft.server.v1_8_R3.PacketPlayOutAbilities packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayOutAbilities unwrap() {return packet;}
public boolean getA() {
try {
return reflect_A.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setA(boolean param) {
try {
reflect_A.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getB() {
try {
return reflect_B.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setB(boolean param) {
try {
reflect_B.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getC() {
try {
return reflect_C.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setC(boolean param) {
try {
reflect_C.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public boolean getD() {
try {
return reflect_D.getBoolean(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setD(boolean param) {
try {
reflect_D.setBoolean(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public float getE() {
try {
return reflect_E.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setE(float param) {
try {
reflect_E.setFloat(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public float getF() {
try {
return reflect_F.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setF(float param) {
try {
reflect_F.setFloat(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayOutAbilities[" + getA()+", "+getB()+", "+getC()+", "+getD()+", "+getE()+", "+getF() + "]";
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