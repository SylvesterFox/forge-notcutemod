package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainMod.MOD_ID);

    public static final RegistryObject<Item> NOT_CUTE_SIGN = ITEMS.register("sign_not_cute", () ->
            new BlockItem(InitBlocks.NOT_CUTE_SIGN.get(), new Item.Properties().tab(InitItemGroup.NOT_CUTE_TAB)));
    public static final RegistryObject<Item> FIXED_NOT_CUTE_SIGN = ITEMS.register("fixed_sign_not_cute", () ->
            new BlockItem(InitBlocks.FIXED_NOT_CUTE_SIGN.get(), new Item.Properties().tab(InitItemGroup.NOT_CUTE_TAB)));

}
