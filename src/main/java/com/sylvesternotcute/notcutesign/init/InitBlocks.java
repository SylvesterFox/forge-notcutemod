package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.blocks.BadDragonKnot;
import com.sylvesternotcute.notcutesign.blocks.FixedNotCuteSign;
import com.sylvesternotcute.notcutesign.blocks.NotCuteSign;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            MainMod.MOD_ID);

    public static final RegistryObject<Block> NOT_CUTE_SIGN = BLOCKS.register("sign_not_cute", () -> new NotCuteSign(PropertiesInit.NOT_CUTE_SIGN));
    public static final RegistryObject<Block> FIXED_NOT_CUTE_SIGN = BLOCKS.register("fixed_sign_not_cute", () -> new FixedNotCuteSign(PropertiesInit.NOT_CUTE_SIGN));
    public static final RegistryObject<Block> BAD_DRAGON_KNOT = BLOCKS.register("bad_dragon_knot", () -> new BadDragonKnot(PropertiesInit.BAD_DRAGON_KNOT));

}
