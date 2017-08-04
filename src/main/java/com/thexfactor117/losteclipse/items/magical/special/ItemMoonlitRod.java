package com.thexfactor117.losteclipse.items.magical.special;

import com.thexfactor117.losteclipse.items.base.ISpecial;
import com.thexfactor117.losteclipse.items.magical.ItemLEMagical;
import com.thexfactor117.losteclipse.loot.ItemGeneratorHelper;
import com.thexfactor117.losteclipse.stats.weapons.Rarity;
import com.thexfactor117.losteclipse.stats.weapons.WeaponAttribute;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemMoonlitRod extends ItemLEMagical implements ISpecial
{
	public ItemMoonlitRod(String name, double baseDamage, double attackSpeed, int manaPerUse, int durability) 
	{
		super(name, baseDamage, attackSpeed, manaPerUse, durability);
	}

	@Override
	public void createSpecial(ItemStack stack, NBTTagCompound nbt, BlockPos pos) 
	{
		Rarity.setRarity(nbt, Rarity.LEGENDARY);
		nbt.setInteger("Level", (int) (Math.random() * 10 + 1));
		ItemGeneratorHelper.setRune(nbt);
		
		// Attributes
		WeaponAttribute.INTELLIGENCE.addAttribute(nbt, 3);
		WeaponAttribute.WISDOM.addAttribute(nbt, 3);
		WeaponAttribute.LIGHTNING.addAttribute(nbt, 5);
		
		// Damage and Attack Speed
		double baseDamage = this.getBaseDamage();
		double baseAttackSpeed = this.getBaseAttackSpeed();
		double weightedDamage = ItemGeneratorHelper.getWeightedDamage(nbt, Rarity.getRarity(nbt), baseDamage);
		double weightedAttackSpeed = ItemGeneratorHelper.getWeightedAttackSpeed(Rarity.getRarity(nbt), baseAttackSpeed);
		
		ItemGeneratorHelper.setMinMaxDamage(nbt, weightedDamage);
		nbt.setDouble("AttackSpeed", weightedAttackSpeed);
	}
}