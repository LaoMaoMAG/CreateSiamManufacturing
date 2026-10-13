package net.meownest.createsiammfg.content.block.engineersWorkbench;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.meownest.createsiammfg.registry.CSMItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;

import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.AllShapes;

import net.meownest.createsiammfg.registry.CSMBlockEntities;

import java.util.List;

/**
 * 手工台方块类
 */
public class EngineersWorkbenchBlocks extends Block implements IBE<EngineersWorkbenchBlocksEntity> {
    public EngineersWorkbenchBlocks(Properties properties) {
        super(properties);
    }

    /**
     * 获取碰撞箱
     */
    @Override
    public VoxelShape getShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context
    ) {
        return AllShapes.CASING_13PX.get(Direction.UP);
    }

    @Override
    public Class<EngineersWorkbenchBlocksEntity> getBlockEntityClass() {
        return EngineersWorkbenchBlocksEntity.class;
    }

    @Override
    public BlockEntityType<? extends EngineersWorkbenchBlocksEntity> getBlockEntityType() {
        return CSMBlockEntities.CRAFTING_TABLE.get();
    }

    /**
     * 物品放置
     */
    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hitResult
    ) {
        if (hitResult.getDirection() != Direction.UP)
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (!(level.getBlockEntity(pos) instanceof EngineersWorkbenchBlocksEntity be))
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (!be.getHeldItem().isEmpty())
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (stack.isEmpty())
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (!level.isClientSide) {
            be.setHeldItem(stack.copyWithCount(1));
            if (!player.getAbilities().instabuild)
                stack.shrink(1);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    /*
     * 物品取回
     */
    @Override
    protected InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hitResult
    ) {
        if (hitResult.getDirection() != Direction.UP)
            return InteractionResult.PASS;

        if (!(level.getBlockEntity(pos) instanceof EngineersWorkbenchBlocksEntity be))
            return InteractionResult.PASS;

        if (be.getHeldItem().isEmpty())
            return InteractionResult.PASS;

        if (!level.isClientSide) {
            ItemStack stack = be.removeHeldItem();
            if (!player.getInventory().add(stack))
                player.drop(stack, false);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
