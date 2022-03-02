package com.sylvesternotcute.notcutesign.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.AbstractMapItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class PropertiesInit {
//blocks
    public static final AbstractBlock.Properties NOT_CUTE_SIGN = AbstractBlock.Properties.of(Material.WOOD)
            .strength(2.0f, 2.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE);

    public static final AbstractBlock.Properties BAD_DRAGON_KNOT = AbstractBlock.Properties.of(Material.SPONGE)
            .strength(0.5f, 0.5f)
            .sound(SoundType.HONEY_BLOCK)
            .harvestTool(ToolType.PICKAXE);
// items
    public static final Item.Properties ROGUELIKE = new Item.Properties().food(new
            Food.Builder().fast().nutrition(10).saturationMod(3.5f).build());

}
