package com.sylvesternotcute.notcutesign.blocks;

import com.sylvesternotcute.notcutesign.entity.SeatEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class BadDragonKnot extends CustomShapeBlock
{
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(7.75, 0.5, 7.55, 8.25, 1.5, 8.05),
            Block.box(6.75, 0, 6.5, 9.25, 0.5, 9.25),
            Block.box(7.16, 2.2, 7.46, 8.86, 10.95, 8.86),
            Block.box(7.67, 10.899999999999988, 7.46, 8.37, 11.29999999999999, 7.859999999999999),
            Block.box(7.92, 11.299999999999988, 7.460000000000001, 8.12, 11.39999999999999, 7.660000000000001),
            Block.box(7.999999999999998, 1.4, 7.45, 10.399999999999995, 3.4000000000000004, 9.35),
            Block.box(5.600000000000001, 1.4, 7.45, 8.000000000000002, 3.4000000000000004, 9.35),
            Block.box(7.009999999999996, 2.1, 7.5, 7.159999999999997, 10.3, 8.66),
            Block.box(8.86, 2.1, 7.5, 9.01, 10.3, 8.66),
            Block.box(7.409999999999999, 4.000000000000002, 7.43, 8.61, 10.199999999999992, 7.529999999999999),
            Block.box(7.26, 3.4000000000000012, 8.800000000000008, 8.76, 4.200000000000002, 9.000000000000007)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public BadDragonKnot(Properties properties)
    {
        super(properties);
        runCalculation(SHAPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
    }



    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result)
    {
        return SeatEntity.create(world, pos, 0.2, playerEntity);
    }

}
