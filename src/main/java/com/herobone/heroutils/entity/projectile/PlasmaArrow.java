package com.herobone.heroutils.entity.projectile;

import com.herobone.heroutils.registry.ItemRegistry;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class PlasmaArrow extends EntityArrow {

	public PlasmaArrow(World worldIn)
    {
        super(worldIn);
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
        this.setSize(0.5F, 0.5F);
    }

    public PlasmaArrow(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    public PlasmaArrow(World worldIn, EntityLivingBase shooter)
    {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
        }
    }
	
	@Override
    public void onUpdate()
    {
        super.onUpdate();
 
        for (int i = 0; i < 4; i++)
        {
            worldObj.spawnParticle(EnumParticleTypes.LAVA, posX, posY, posZ, 1, 1, 1, new int[0]);
        }
        
        if (this.inGround) {
        	this.setDead();
        }
    }

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ItemRegistry.plasmaprojectile);
	}
	
    protected void arrowHit(EntityLivingBase living)
    {
        living.setDead();
    }

}
