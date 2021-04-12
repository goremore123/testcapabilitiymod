package com.example.examplemod.object.item;

import com.example.examplemod.capabilities.ManaProvider;
import com.example.examplemod.init.ItemInit;
import com.example.examplemod.proxy.ClientProxy;
import com.example.examplemod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CapaItem extends Item implements IHasModel {


    public CapaItem() {
        setRegistryName("CapaItem");
        setCreativeTab(CreativeTabs.FOOD);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registryItemRender() {
        ClientProxy.registryItemRender(this,0,"inventory");
    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        assert false;
        System.out.println(player.getCapability(ManaProvider.MANA_CAPABILITY, EnumFacing.NORTH).getMana());
        player.getCapability(ManaProvider.MANA_CAPABILITY, EnumFacing.NORTH).setMana(player.getCapability(ManaProvider.MANA_CAPABILITY, EnumFacing.NORTH).getMana() + 1);
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
