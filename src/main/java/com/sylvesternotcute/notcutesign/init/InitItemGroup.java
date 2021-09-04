package com.sylvesternotcute.notcutesign.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

public class InitItemGroup {

    public static ItemGroup createGruop(String id, RegistryObject<Item> icon) {
        return new ItemGroup(id) {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(icon.get());
            }
        };
    }

    public static ItemGroup NOT_CUTE_TAB = createGruop("not_cute_tab", InitItem.NOT_CUTE_SIGN);
}
