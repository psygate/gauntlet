package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInArmAnimationWrapper implements IPacketPlayInArmAnimationWrapper {
private final static java.lang.reflect.Field reflect_Timestamp;
static {
try {
reflect_Timestamp = net.minecraft.server.v1_8_R3.PacketPlayInArmAnimation.class.getDeclaredField("timestamp");
reflect_Timestamp.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInArmAnimation packet;

public PacketPlayInArmAnimationWrapper(net.minecraft.server.v1_8_R3.PacketPlayInArmAnimation packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInArmAnimation unwrap() {return packet;}
public long getTimestamp() {
try {
return reflect_Timestamp.getLong(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setTimestamp(long param) {
try {
reflect_Timestamp.setLong(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayInArmAnimation[" + getTimestamp() + "]";
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