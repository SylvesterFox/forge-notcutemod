package com.sylvesternotcute.notcutesign.items;

import com.sylvesternotcute.notcutesign.init.InitItemGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CreamBucket extends Item {
    public CreamBucket(Properties properties) {
        super(properties.tab(InitItemGroup.NOT_CUTE_TAB));
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity living) {
        if (living instanceof ServerPlayerEntity)
        {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)living;
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }

        if (living instanceof PlayerEntity && !((PlayerEntity)living).abilities.instabuild) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAnimation(ItemStack stack){
        return UseAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return DrinkHelper.useDrink(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
