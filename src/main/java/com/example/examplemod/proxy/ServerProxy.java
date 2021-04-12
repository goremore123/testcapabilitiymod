package com.example.examplemod.proxy;


import com.example.examplemod.capabilities.IMana;
import com.example.examplemod.capabilities.Mana;
import com.example.examplemod.capabilities.ManaStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy {

    public void preInit(FMLPreInitializationEvent event) {

        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana::new);
    }


}
