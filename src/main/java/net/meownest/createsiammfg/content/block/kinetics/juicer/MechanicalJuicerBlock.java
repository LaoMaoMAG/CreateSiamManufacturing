package net.meownest.createsiammfg.content.block.kinetics.juicer;

import net.meownest.createsiammfg.registry.blockEntry.CSMBlockEntities;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/*
 * 动力榨汁机方块类
 */
public class MechanicalJuicerBlock extends KineticBlock implements IBE<MechanicalJuicerBlockEntity>, ICogWheel {
    public MechanicalJuicerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<MechanicalJuicerBlockEntity> getBlockEntityClass() {
        return MechanicalJuicerBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalJuicerBlockEntity> getBlockEntityType() {
        return CSMBlockEntities.MECHANICAL_JUICER.get();
    }
}
