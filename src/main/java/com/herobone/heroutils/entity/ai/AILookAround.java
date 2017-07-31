package com.herobone.heroutils.entity.ai;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.MathHelper;

public class AILookAround extends EntityAIBase
{
    private final EntityFlying parentEntity;

    public AILookAround(EntityFlying ufo)
    {
        this.parentEntity = ufo;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return true;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.parentEntity.getAttackTarget() == null)
        {
            this.parentEntity.rotationYaw = -((float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float)Math.PI);
            this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
            if (entitylivingbase.getDistanceSqToEntity(this.parentEntity) < 4096.0D)
            {
                double d1 = entitylivingbase.posX - this.parentEntity.posX;
                double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
                this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
                this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
            }
        }
    }
}

