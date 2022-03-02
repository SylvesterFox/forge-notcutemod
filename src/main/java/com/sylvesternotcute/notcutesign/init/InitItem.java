package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.items.Roguelike;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainMod.MOD_ID);

    //block item
    public static final RegistryObject<Item> NOT_CUTE_SIGN = ITEMS.register("sign_not_cute", () ->
            new BlockItem(InitBlocks.NOT_CUTE_SIGN.get(), new Item.Properties().tab(InitItemGroup.NOT_CUTE_TAB)));
    public static final RegistryObject<Item> FIXED_NOT_CUTE_SIGN = ITEMS.register("fixed_sign_not_cute", () ->
            new BlockItem(InitBlocks.FIXED_NOT_CUTE_SIGN.get(), new Item.Properties().tab(InitItemGroup.NOT_CUTE_TAB)));
    public static final RegistryObject<Item> BAD_DRAGON_KNOT = ITEMS.register("bad_dragon_knot", () ->
            new BlockItem(InitBlocks.BAD_DRAGON_KNOT.get(), new Item.Properties()));

    // items
    public static final RegistryObject<Item> ROGUELIKE = ITEMS.register("roguelike", () ->
            new Roguelike(PropertiesInit.ROGUELIKE));

}
