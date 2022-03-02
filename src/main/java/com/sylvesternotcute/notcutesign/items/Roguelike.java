package com.sylvesternotcute.notcutesign.items;

import com.sylvesternotcute.notcutesign.init.InitItemGroup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class Roguelike extends Item
{
    public Roguelike(Properties properties) {
        super(properties.tab(InitItemGroup.NOT_CUTE_TAB));
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        tooltip.add(new TranslationTextComponent("notcutedragofox.roguelike.here").withStyle(TextFormatting.DARK_GRAY));
        super.appendHoverText(stack, worldIn, tooltip, flag);
    }
}
