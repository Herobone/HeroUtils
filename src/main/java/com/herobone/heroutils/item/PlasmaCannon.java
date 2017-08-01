package com.herobone.heroutils.item;

import java.util.List;

import javax.annotation.Nullable;

import com.herobone.heroutils.HeroUtils;
import com.herobone.heroutils.entity.projectile.PlasmaArrow;
import com.herobone.heroutils.registry.ItemRegistry;

import mekanism.api.EnumColor;
import mekanism.common.util.ItemDataUtils;
import mekanism.common.util.LangUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class PlasmaCannon extends ItemEnergized {

	public PlasmaCannon() {
		super(1000000);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(LangUtils.localize("tooltip.activity") + ": " + EnumColor.INDIGO + getModeName(stack));
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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player,
			EnumHand hand) {
		if (!player.isSneaking() && getMode(itemStack) != 1) {
			if (!world.isRemote) {
				if (getEnergy(itemStack) > 100) {
					ItemStack ammo = findAmmo(player);
					if (ammo == null && !player.capabilities.isCreativeMode) {
						player.addChatMessage(new TextComponentString(HeroUtils.CHATPREFIX + EnumColor.RED + "No Projectiles!"));
					} else {
						if (ammo == null) {
							ammo = new ItemStack(ItemRegistry.plasmaprojectile);
						}
						PlasmaProjectile itemarrow = (PlasmaProjectile)(ammo.getItem() instanceof PlasmaProjectile ? ammo.getItem() : ItemRegistry.plasmaprojectile);
	                    PlasmaArrow entityarrow = itemarrow.createArrow(world, itemStack, player);
	                    entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 20F, 1.0F);
						world.spawnEntityInWorld(entityarrow);
						setEnergy(itemStack, getEnergy(itemStack) - 100);
						if (!player.capabilities.isCreativeMode) {
							--ammo.stackSize;
							
							if (ammo.stackSize == 0)
	                        {
	                            player.inventory.deleteStack(ammo);
	                        }
						}
					}
				} else {
					player.addChatMessage(new TextComponentString(HeroUtils.CHATPREFIX + EnumColor.GREY + "Energy to low!"));
				}
			}
		} else if (player.isSneaking()) {
			toggleMode(itemStack);
			player.addChatMessage(new TextComponentString(HeroUtils.CHATPREFIX + EnumColor.GREY + "Plasma Cannon: " + EnumColor.INDIGO + getModeName(itemStack)));
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
	}
	
	public int getMode(ItemStack itemStack)
	{
		return ItemDataUtils.getInt(itemStack, "activation");
	}

	public String getModeName(ItemStack itemStack)
	{
		int mode = getMode(itemStack);
		
		if (mode == 0) {
			return LangUtils.localize("tooltip.plasmacannon.active");
		} else if (mode == 1) {
			return LangUtils.localize("tooltip.plasmacannon.deactive");
		} else {
			return null;
		}
	}

	public void toggleMode(ItemStack itemStack)
	{
		ItemDataUtils.setInt(itemStack, "activation", getMode(itemStack) == 1 ? 0 : 1);
	}
	
}
