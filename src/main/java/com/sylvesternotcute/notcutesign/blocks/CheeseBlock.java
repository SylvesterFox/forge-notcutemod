package com.sylvesternotcute.notcutesign.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;


public class CheeseBlock extends Block {
    public static final IntegerProperty BITES_CHEESE = IntegerProperty.create("bites_cheese", 0, 3);
    private static final VoxelShape BITES_CHEESE_0 = Block.box(2, 0, 2, 8, 6, 8);
    private static final VoxelShape BITES_CHEESE_1 = Block.box(2, 0, 8, 8, 6, 14);
    private static final VoxelShape BITES_CHEESE_2 = Block.box(8, 0, 8, 14, 6, 14);
    private static final VoxelShape BITES_CHEESE_3 = Block.box(8, 0, 2, 14, 6, 8);
    private static final VoxelShape CHEESE_BLOCK = VoxelShapes.or(BITES_CHEESE_0, BITES_CHEESE_1, BITES_CHEESE_2, BITES_CHEESE_3);


    public CheeseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(BITES_CHEESE, Integer.valueOf(0)));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos blockPos, ISelectionContext context) {
        return state.getValue(BITES_CHEESE) > 4 ? BITES_CHEESE_0 : CHEESE_BLOCK;
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
            entity.getFoodData().eat(5, 2.5f);
            int i = state.getValue(BITES_CHEESE);
            if (i < 3) {
                iWorld.setBlock(blockPos, state.setValue(BITES_CHEESE, Integer.valueOf(i + 1)), 3);
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
        p_206840_1_.add(BITES_CHEESE);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos blockPos) {
        return (4 - state.getValue(BITES_CHEESE)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType pathType) {
        return false;
    }


}
