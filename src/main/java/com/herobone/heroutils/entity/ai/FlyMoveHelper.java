package com.herobone.heroutils.entity.ai;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class FlyMoveHelper extends EntityMoveHelper {
    private final EntityFlying parentEntity;
    private int courseChangeCooldown;

    public FlyMoveHelper(EntityFlying ufo)
    {
        super(ufo);
        this.parentEntity = ufo;
    }

    public void onUpdateMoveHelper()
    {
        if (this.action == EntityMoveHelper.Action.MOVE_TO)
        {
            double d0 = this.posX - this.parentEntity.posX;
            double d1 = this.posY - this.parentEntity.posY;
            double d2 = this.posZ - this.parentEntity.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;

            if (this.courseChangeCooldown-- <= 0)
            {
                this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                d3 = (double)MathHelper.sqrt_double(d3);

                if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
                {
                    this.parentEntity.motionX += d0 / d3 * 0.1D;
                    this.parentEntity.motionY += d1 / d3 * 0.1D;
                    this.parentEntity.motionZ += d2 / d3 * 0.1D;
                }
                else
                {
                    this.action = EntityMoveHelper.Action.WAIT;
                }
            }
        }
    }

    /**
     * Checks if entity bounding box is not colliding with terrain
     */
    private boolean isNotColliding(double x, double y, double z, double doubleIn)
    {
        double d0 = (x - this.parentEntity.posX) / doubleIn;
        double d1 = (y - this.parentEntity.posY) / doubleIn;
        double d2 = (z - this.parentEntity.posZ) / doubleIn;
        AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

        for (int i = 1; (double)i < doubleIn; ++i)
        {
            axisalignedbb = axisalignedbb.offset(d0, d1, d2);

            if (!this.parentEntity.worldObj.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
            {
                return false;
            }
        }

        return true;
    }
}
