package com.sylvesternotcute.notcutesign.items.custom;

import com.sylvesternotcute.notcutesign.init.InitEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.common.util.Constants;

import java.util.Objects;

public class FennecEgg extends Item {
    public FennecEgg(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            ItemStack itemStack = context.getItemInHand();
            BlockPos blockPos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockState = world.getBlockState(blockPos);
            TileEntity tileEntity = world.getBlockEntity(blockPos);
            if (tileEntity instanceof MobSpawnerTileEntity)
            {
                AbstractSpawner abstractSpawner = ((MobSpawnerTileEntity) tileEntity).getSpawner();
                abstractSpawner.setEntityId(InitEntities.FENNEC_FOX.get());
                tileEntity.setChanged();
                world.sendBlockUpdated(blockPos, blockState, blockState, Constants.BlockFlags.BLOCK_UPDATE + Constants.BlockFlags.NOTIFY_NEIGHBORS);
                itemStack.shrink(1);
                return ActionResultType.SUCCESS;
            }

            BlockPos blockPos1;
            if (blockState.getCollisionShape(world, blockPos).isEmpty())
            {
                blockPos1 = blockPos;
            } else {
                blockPos1 = blockPos.relative(direction);
            }

            if (InitEntities.FENNEC_FOX.get().spawn((ServerWorld) world, itemStack, context.getPlayer(), blockPos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockPos1) && direction == Direction.UP) !=null)
            {
                itemStack.shrink(1);
            }

            return ActionResultType.SUCCESS;
        }

    }

}
