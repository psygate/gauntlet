package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInCloseWindowWrapper implements IPacketPlayInCloseWindowWrapper {
private final static java.lang.reflect.Field reflect_Id;
static {
try {
reflect_Id = net.minecraft.server.v1_8_R3.PacketPlayInCloseWindow.class.getDeclaredField("id");
reflect_Id.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInCloseWindow packet;

public PacketPlayInCloseWindowWrapper(net.minecraft.server.v1_8_R3.PacketPlayInCloseWindow packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInCloseWindow unwrap() {return packet;}
public int getId() {
try {
return reflect_Id.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setId(int param) {
try {
reflect_Id.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayInCloseWindow[" + getId() + "]";
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