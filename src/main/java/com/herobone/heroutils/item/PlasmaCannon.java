package com.herobone.heroutils.item;

import java.util.List;

import javax.annotation.Nullable;

import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.registry.ItemRegistry;

import mekanism.api.ItemDataUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class PlasmaCannon extends ItemEnergized {

	public PlasmaCannon() {
		super(100000);
	}
	
	public static boolean isDeactive = false;
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add("\u00A7c" + "Energy: " + getEnergy(stack) + "/" + getMaxEnergy(stack));
	}
	
	private ItemStack findAmmo(EntityPlayer player)
    {
        if(isAmmo(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if(isAmmo(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else {
            for(int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if(isAmmo(itemstack))
                {
                    return itemstack;
                }
            }

            return null;
        }
    }

    protected boolean isAmmo(@Nullable ItemStack stack)
    {
        return stack != null && stack.getItem() instanceof PlasmaProjectile;
    }
	
	@Override
	public ActionResult onItemRightClick(ItemStack itemStack, World world, EntityPlayer player,
			EnumHand hand) {
		if (!player.isSneaking() && !isDeactive) {
			if (!world.isRemote) {
				if (getEnergy(itemStack) > 100) {
					ItemStack ammo = findAmmo(player);
					if (ammo == null) {
						ammo = new ItemStack(ItemRegistry.plasmaprojectile);
					}
					PlasmaProjectile itemarrow = (PlasmaProjectile)(ammo.getItem() instanceof PlasmaProjectile ? ammo.getItem() : ItemRegistry.plasmaprojectile);
                    PlasmaArrow entityarrow = itemarrow.createArrow(world, itemStack, player);
                    //EntityArrow entityarrow = itemarrow.createArrow(world, itemStack, player);
                    entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 20F, 1.0F);
					world.spawnEntityInWorld(entityarrow);
					setEnergy(itemStack, getEnergy(itemStack) - 100);
				} else {
					player.addChatMessage(new TextComponentString("§5Energy to low!"));
				}
			}
		} else if (player.isSneaking()) {
			if (!isDeactive) {
				ItemDataUtils.setBoolean(itemStack, "isDeactive", !isDeactive);
				isDeactive = !isDeactive;
				player.addChatMessage(new TextComponentString("Deactivated"));
			} else if (isDeactive) {
				ItemDataUtils.setBoolean(itemStack, "isDeactive", !isDeactive);
				isDeactive = !isDeactive;
				player.addChatMessage(new TextComponentString("Activated"));
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}
	
}
