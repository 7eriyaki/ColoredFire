package com.software.ddk.coloredfire.common.material;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GenericToolMaterial implements ToolMaterial{
	private int durability;
	private float miningSpeed;
	private float attackDamage;
	private int miningLevel;
	private int enchantability;
	private Ingredient repairIngredient;

	public static ToolMaterial FLINT_TOOL_MATERIAL = new GenericToolMaterial(150, 1.0f, 1.0f, 1, 1, Ingredient.ofItems(Items.FLINT));

	private GenericToolMaterial(int durability, float miningSpeed, float attackDamage, int miningLevel, int enchantability, Ingredient ingredient){
		this.durability = durability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.miningLevel = miningLevel;
		this.enchantability = enchantability;
		this.repairIngredient = ingredient;
	}

	@Override
	public int getDurability() {
		return durability;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return miningSpeed;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return miningLevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient;
	}

}
