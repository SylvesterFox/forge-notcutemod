package com.sylvesternotcute.notcutesign.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PropertiesInit {

    public static final AbstractBlock.Properties NOT_CUTE_SIGN = AbstractBlock.Properties.of(Material.WOOD)
            .strength(2.0f, 2.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE);
}
