package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInTransactionWrapper implements IPacketPlayInTransactionWrapper {
private final static java.lang.reflect.Field reflect_A;
private final static java.lang.reflect.Field reflect_B;
private final static java.lang.reflect.Field reflect_C;
static {
try {
reflect_A = net.minecraft.server.v1_8_R3.PacketPlayInTransaction.class.getDeclaredField("a");
reflect_A.setAccessible(true);reflect_B = net.minecraft.server.v1_8_R3.PacketPlayInTransaction.class.getDeclaredField("b");
reflect_B.setAccessible(true);reflect_C = net.minecraft.server.v1_8_R3.PacketPlayInTransaction.class.getDeclaredField("c");
reflect_C.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInTransaction packet;

public PacketPlayInTransactionWrapper(net.minecraft.server.v1_8_R3.PacketPlayInTransaction packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInTransaction unwrap() {return packet;}
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
public short getB() {
try {
return reflect_B.getShort(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setB(short param) {
try {
reflect_B.setShort(packet, param);
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
    @Override
    public String toString() {
        return "PacketPlayInTransaction[" + getA()+", "+getB()+", "+getC() + "]";
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