package com.example.examplemod.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ManaStorage implements IStorage<IMana> {

    public static final ManaStorage INSTANCE = new ManaStorage();


    @Override
    public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("Mana", instance.getMana());
        return nbt;
    }


    @Override
    public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tag = (NBTTagCompound) nbt;
        instance.setMana(tag.getInteger("Mana"));
    }
}
