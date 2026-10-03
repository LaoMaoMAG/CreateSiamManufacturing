package net.meownest.createsiammfg.registry;

import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerBlockEntity;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerRenderer;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerVisual;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.simibubi.create.foundation.data.CreateRegistrate;

/**
 * CMS 方块实体注册类
 */

public class CSMBlockEntities {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    /**
     * 动力榨汁机
     */
    public static final BlockEntityEntry<MechanicalJuicerBlockEntity> MECHANICAL_JUICER = REGISTRATE
            .blockEntity("mechanical_juicer", MechanicalJuicerBlockEntity::new)
            .visual(() -> MechanicalJuicerVisual::new)
            .validBlocks(CSMBlocks.MECHANICAL_JUICER)
            .renderer(() -> MechanicalJuicerRenderer::new)
            .register();

    public static void register() {
    }
}
