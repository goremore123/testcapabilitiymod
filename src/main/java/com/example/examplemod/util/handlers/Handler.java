package com.example.examplemod.util.handlers;

import com.example.examplemod.capabilities.ManaProvider;
import com.example.examplemod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber
public class Handler {


    @SubscribeEvent
    public static void attachEntity(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            ManaProvider manaCap = new ManaProvider();
            event.addCapability(new ResourceLocation(Reference.MODID, "Mana"), manaCap);

        }
    }



}
