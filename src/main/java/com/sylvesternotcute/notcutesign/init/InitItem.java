package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.items.*;
import com.sylvesternotcute.notcutesign.items.custom.ModSpawnEgg;
import net.minecraft.item.*;
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
    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife", () -> new ItemKnife(ItemTier.IRON, 1, 24f, PropertiesInit.KNIFE));


    // egg item
    public static final RegistryObject<ModSpawnEgg> FENNEC_EGG = ITEMS.register("fennec_egg", () -> new ModSpawnEgg(InitEntities.FENNEC_FOX, 0xFFBE73, 0xEA6900, PropertiesInit.FENNEC_EGG));

}
