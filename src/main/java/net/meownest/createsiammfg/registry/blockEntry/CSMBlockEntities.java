package net.meownest.createsiammfg.registry.blockEntry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerBlockEntity;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerRenderer;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerVisual;
import net.meownest.createsiammfg.registry.CSMRegistrate;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.meownest.createsiammfg.registry.block.CSMBlocks;

/**
 * CMS 方块实体注册类
 */

public class CSMBlockEntities {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    /**
     * 动力榨汁机
     */
    public static final BlockEntityEntry<MechanicalJuicerBlockEntity> MECHANICAL_JUICER =
            REGISTRATE.blockEntity("mechanical_juicer", MechanicalJuicerBlockEntity::new)
                    .validBlocks(CSMBlocks.MECHANICAL_JUICER)
                    .register();

}
