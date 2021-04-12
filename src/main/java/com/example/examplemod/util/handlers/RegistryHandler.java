package com.example.examplemod.util.handlers;

import com.example.examplemod.init.ItemInit;
import com.example.examplemod.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void  ItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void ModelRegister(ModelRegistryEvent event){
        for(Item item: ItemInit.ITEMS){
            if (item instanceof IHasModel){
                ((IHasModel)item).registryItemRender();
            }
        }

    }
}
