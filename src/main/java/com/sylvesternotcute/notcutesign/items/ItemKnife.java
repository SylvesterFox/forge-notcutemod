package com.sylvesternotcute.notcutesign.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemKnife extends TieredItem implements IVanishable {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifier;


   public ItemKnife(IItemTier itemTier, int int_attackDamage, float speedDamage, Properties properties) {
       super(itemTier, properties);
       this.attackDamage = (float) int_attackDamage + itemTier.getAttackDamageBonus();
       Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
       builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
       builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double) speedDamage, AttributeModifier.Operation.ADDITION));
       this.defaultModifier = builder.build();
   }

   public float getDamage() {
       return this.attackDamage;
   }

   @Override
   public boolean canAttackBlock(BlockState state, World world, BlockPos pos, PlayerEntity entity) {
       return entity.isCreative();
   }

   public boolean hurtEnemy(ItemStack stack, LivingEntity entity_0, LivingEntity entity_1) {
       stack.hurtAndBreak(1, entity_1, (ItemStack) -> {
           ItemStack.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
       });
       return true;
   }

   @Override
   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slotType) {
       return slotType == EquipmentSlotType.MAINHAND ? this.defaultModifier : super.getDefaultAttributeModifiers(slotType);
   }

}
