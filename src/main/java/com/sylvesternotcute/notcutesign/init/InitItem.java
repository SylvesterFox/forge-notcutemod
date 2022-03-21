package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.items.BerryJam;
import com.sylvesternotcute.notcutesign.items.Cheese;
import com.sylvesternotcute.notcutesign.items.CreamBucket;
import com.sylvesternotcute.notcutesign.items.Roguelike;
import com.sylvesternotcute.notcutesign.items.custom.FennecEgg;
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
    public static final RegistryObject<Item> CHEESE_BLOCK = ITEMS.register("cheese_block", () ->
            new BlockItem(InitBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(InitItemGroup.NOT_CUTE_TAB)));

    // items
    public static final RegistryObject<Item> ROGUELIKE = ITEMS.register("roguelike", () ->
            new Roguelike(PropertiesInit.ROGUELIKE));
    public static final RegistryObject<Item> BERRY_JAM = ITEMS.register("berry_jam", () ->
            new BerryJam(PropertiesInit.BERRY_JAM));
    public static final RegistryObject<Item> CREAM_BUCKET = ITEMS.register("cream_bucket", () ->
            new CreamBucket(PropertiesInit.CREAM_BUCKET));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese_item", () -> new Cheese(PropertiesInit.CHEESE));

    // egg item
    public static final RegistryObject<Item> FENNEC_EGG = ITEMS.register("fennec_egg", () -> new FennecEgg(PropertiesInit.FENNEC_EGG));

}
