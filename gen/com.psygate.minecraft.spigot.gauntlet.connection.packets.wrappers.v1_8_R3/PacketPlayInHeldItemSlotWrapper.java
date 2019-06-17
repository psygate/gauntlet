package com.psygate.minecraft.spigot.gauntlet.connection.packets.wrappers.v1_8_R3;
import java.util.Objects;
//Gauntlet generated wrapper class.
public class PacketPlayInHeldItemSlotWrapper implements IPacketPlayInHeldItemSlotWrapper {
private final static java.lang.reflect.Field reflect_ItemInHandIndex;
static {
try {
reflect_ItemInHandIndex = net.minecraft.server.v1_8_R3.PacketPlayInHeldItemSlot.class.getDeclaredField("itemInHandIndex");
reflect_ItemInHandIndex.setAccessible(true);} catch(Exception e) {throw new RuntimeException(e);}
}
private net.minecraft.server.v1_8_R3.PacketPlayInHeldItemSlot packet;

public PacketPlayInHeldItemSlotWrapper(net.minecraft.server.v1_8_R3.PacketPlayInHeldItemSlot packet) {
this.packet = Objects.requireNonNull(packet, () -> "Provided packet for wrapper cannot be null.");
}

public net.minecraft.server.v1_8_R3.PacketPlayInHeldItemSlot unwrap() {return packet;}
public int getItemInHandIndex() {
try {
return reflect_ItemInHandIndex.getInt(packet);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
public void setItemInHandIndex(int param) {
try {
reflect_ItemInHandIndex.setInt(packet, param);
} catch(Exception e) {
throw new RuntimeException(e);
}
}
    @Override
    public String toString() {
        return "PacketPlayInHeldItemSlot[" + getItemInHandIndex() + "]";
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