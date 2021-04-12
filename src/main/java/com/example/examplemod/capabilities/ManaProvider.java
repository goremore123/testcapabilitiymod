package com.example.examplemod.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaProvider implements ICapabilitySerializable<NBTTagCompound> {


    @CapabilityInject(IMana.class)
    public static Capability<IMana> MANA_CAPABILITY;
    private final IMana capability = new Mana();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return (capability == MANA_CAPABILITY)  && (facing == EnumFacing.NORTH);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if ((capability == MANA_CAPABILITY) && (facing == EnumFacing.NORTH)) return (T) this.capability;
        return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) ManaStorage.INSTANCE.writeNBT(ManaProvider.MANA_CAPABILITY, new Mana(), EnumFacing.NORTH);
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        ManaStorage.INSTANCE.readNBT(ManaProvider.MANA_CAPABILITY, new Mana(), EnumFacing.NORTH, nbt);
    }
}
