package net.meownest.createsiammfg.content.block.kinetics.juicer;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/*
 * 动力榨汁机方块类
 */
public class MechanicalJuicerBlock extends KineticBlock implements IBE<MechanicalMixerBlockEntity>, ICogWheel { // 需要修改
    public MechanicalJuicerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<MechanicalMixerBlockEntity> getBlockEntityClass() {
        return MechanicalMixerBlockEntity.class; // 需要修改
    }

    @Override
    public BlockEntityType<? extends MechanicalMixerBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.MECHANICAL_MIXER.get(); // 需要修改
    }
}
