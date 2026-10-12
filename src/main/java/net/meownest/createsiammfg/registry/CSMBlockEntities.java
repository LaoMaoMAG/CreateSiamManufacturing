package net.meownest.createsiammfg.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.simibubi.create.foundation.data.CreateRegistrate;

import net.meownest.createsiammfg.client.renderer.CraftingTableRenderer;
import net.meownest.createsiammfg.content.block.craftingTable.CraftingTableBlocksEntity;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerBlockEntity;
import net.meownest.createsiammfg.client.renderer.MechanicalJuicerRenderer;
import net.meownest.createsiammfg.client.visual.MechanicalJuicerVisual;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

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

    /**
     * 手工台
     */
    public static final BlockEntityEntry<CraftingTableBlocksEntity> CRAFTING_TABLE = REGISTRATE
            .blockEntity("crafting_table", CraftingTableBlocksEntity::new)
            .validBlocks(CSMBlocks.CRAFTING_TABLE)
            .renderer(() -> CraftingTableRenderer::new)
            .register();

    public static void register() {
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                CRAFTING_TABLE.get(),
                (be, side) -> be.getItemHandler()
        );
    }
}
