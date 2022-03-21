package com.sylvesternotcute.notcutesign.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.AbstractMapItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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

    public static final AbstractBlock.Properties CHEESE_BLOCK = AbstractBlock.Properties.of(Material.CAKE)
            .strength(0.2f)
            .sound(SoundType.WOOL);


    // items foods
    public static final Item.Properties ROGUELIKE = new Item.Properties().food(new
            Food.Builder().fast().nutrition(10).saturationMod(3.5f).build());

    public static final Item.Properties BERRY_JAM = new Item.Properties().food(new Food.Builder()
            .effect(() -> new EffectInstance(Effects.REGENERATION, 200, 1), 1.0f).nutrition(5).saturationMod(0.4f).build());

    public static final Item.Properties CHEESE = new Item.Properties().food(new Food.Builder().nutrition(5).saturationMod(2.5f).build());

    // items
    public static final Item.Properties CREAM_BUCKET = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1);

    // items egg
    public static final Item.Properties FENNEC_EGG = new Item.Properties().stacksTo(1).tab(InitItemGroup.NOT_CUTE_TAB);

}
