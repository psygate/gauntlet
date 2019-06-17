package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInSteerVehicleWrapper implements IPacketPlayInSteerVehicleWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
private final static java.lang.reflect.Field reflect_D;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle.class.getDeclaredField("c");
reflect_C.setAccessible(true);reflect_D = net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle.class.getDeclaredField("d");
reflect_D.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle packet;

public PacketPlayInSteerVehicleWrapper(net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInSteerVehicle unwrap() {return packet;}
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
public float getB() {
try {
return reflect_B.getFloat(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setB(float param) {
try {
reflect_B.setFloat(packet, param);
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
    @Override
    public String toString() {
        return "PacketPlayInSteerVehicle[" + getA()+", "+getB()+", "+getC()+", "+getD() + "]";
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