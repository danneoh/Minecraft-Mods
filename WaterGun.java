package com.idtech.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;

public class WaterGun extends QuickItem{
    {
        /*Give the gun certain properties*/
        /*Name is how you will find it in your inventory in game*/
        /*Tab is which tab you will find it in, in game*/
        /*Texture is the name of the png associated with how the gun will look in game*/
        name = "Water Gun";
        tab = CreativeTabs.COMBAT;
        texture = "watergun";
    }
    /*Method for shooting the arrows when player clicks the right button on mouse or trackpad*/
    public void onRightClick(){
        if(!world.isRemote){
            /*Creates new stack of arrows to be used as ammo*/
            ItemArrow itemArrow = (ItemArrow) Items.ARROW;
            ItemStack itemStack = new ItemStack(itemArrow);
            EntityArrow entityArrow = itemArrow.createArrow(world, itemStack, player);

            /*Shoots the arrow in the direction that the players cross hairs is facing*/
            entityArrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 3.0F, 1.0F);
            /*Makes the arrow appear in the world and we can see it trajectory*/
            world.spawnEntity(entityArrow);

        }
    }

}
