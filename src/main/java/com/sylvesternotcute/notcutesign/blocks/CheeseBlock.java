package com.sylvesternotcute.notcutesign.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CheeseBlock extends Block {
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    protected static final VoxelShape[] SHAPE_BY_BITES = new VoxelShape[]{
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)
    };

    public CheeseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(BITES, Integer.valueOf(0)));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos blockPos, ISelectionContext context) {
        return SHAPE_BY_BITES[state.getValue(BITES)];
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if (worldIn.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);

            if (this.eat(worldIn, blockPos, state, player).consumesAction()) {
                return ActionResultType.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResultType.SUCCESS;
            }

        }
        return this.eat(worldIn, blockPos, state, player);
    }


    private ActionResultType eat(IWorld iWorld, BlockPos blockPos, BlockState state, PlayerEntity entity) {
        if (!entity.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            entity.awardStat(Stats.EAT_CAKE_SLICE);
            entity.getFoodData().eat(2, 0.3f);
            int i = state.getValue(BITES);
            if (i < 6) {
                iWorld.setBlock(blockPos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                iWorld.removeBlock(blockPos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state_0, IWorld world, BlockPos blockPos_0, BlockPos blockPos_1) {
        return direction == Direction.DOWN && !state.canSurvive(world, blockPos_0) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state_0, world, blockPos_0, blockPos_1);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldReader, BlockPos blockPos) {
        return worldReader.getBlockState(blockPos.below()).getMaterial().isSolid();
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        super.createBlockStateDefinition(p_206840_1_);
        p_206840_1_.add(BITES);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos blockPos) {
        return (7 - state.getValue(BITES)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType pathType) {
        return false;
    }

}
