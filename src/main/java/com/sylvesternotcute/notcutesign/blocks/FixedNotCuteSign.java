package com.sylvesternotcute.notcutesign.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import java.util.List;
import java.util.stream.Stream;

public class FixedNotCuteSign extends CustomShapeBlock{

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(1, 21, 8, 15, 22, 9),
            Block.box(9, 12, 8, 15, 13, 9),
            Block.box(1, 12, 8, 7, 13, 9),
            Block.box(1, 13, 8, 2, 21, 9),
            Block.box(14, 13, 8, 15, 21, 9),
            Block.box(7, 0, 8, 9, 21, 9),
            Block.box(1, 12, 7, 15, 22, 8)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public FixedNotCuteSign(Properties properties)
    {
        super(properties);
        runCalculation(SHAPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
    }

    @Override
    public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        tooltip.add(new TranslationTextComponent("notcutedragofox.fixed_not_cute_sign.here").withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, worldIn, tooltip, flag);
    }
}
