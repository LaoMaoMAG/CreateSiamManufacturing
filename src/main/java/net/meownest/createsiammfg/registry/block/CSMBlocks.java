package net.meownest.createsiammfg.registry.block;

import net.meownest.createsiammfg.content.block.craftingTable.CraftingTableBlocks;
import net.meownest.createsiammfg.registry.CSMRegistrate;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

/**
 * CMS 方块注册类
 */
public class CSMBlocks {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    /**
     * 手工台
     */
    public static final BlockEntry<?> CRAFTING_TABLE = REGISTRATE.block("crafting_table", CraftingTableBlocks::new)
            .register();
}
