package thexfactor117.lsc.entities.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import thexfactor117.lsc.capabilities.cap.CapabilityPlayerStats;
import thexfactor117.lsc.capabilities.implementation.Stats;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityLightning extends EntityProjectileBase
{
	private int amount;
	
	public EntityLightning(World world) 
	{
		super(world);
	}
	
	/** Only use this constructor if a player shoots the projectile with the correct item. */
	public EntityLightning(World world, double x, double y, double z, float velocity, float inaccuracy, EntityPlayer player, ItemStack stack, int amount)
	{
		super(world, x, y, z, velocity, inaccuracy, player, stack);
		this.amount = amount;
	}
	
	@Override
	public void onImpact(RayTraceResult result)
	{
		super.onImpact(result);
		
		if (!this.getEntityWorld().isRemote)
		{
			if (result.entityHit != null && result.entityHit instanceof EntityPlayer && result.entityHit != player)
			{
				Stats statsCap = (Stats) result.entityHit.getCapability(CapabilityPlayerStats.STATS, null);
				
				if (statsCap != null)
				{
					statsCap.decreaseMana(amount);
				}
			}
			
			this.setDead();
		}
	}
}
