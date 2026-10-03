package net.meownest.createsiammfg.registry;

import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import net.meownest.createsiammfg.content.block.craftingTable.CraftingTableBlocks;
import net.meownest.createsiammfg.content.block.kinetics.juicer.MechanicalJuicerBlock;
import net.meownest.createsiammfg.content.block.kinetics.screening.MechanicalScreeningBlock;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

/**
 * CMS 方块注册类
 */
public class CSMBlocks {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    /**
     * 动力榨汁机
     */
    public static final BlockEntry<MechanicalJuicerBlock> MECHANICAL_JUICER = REGISTRATE
            .block("mechanical_juicer", MechanicalJuicerBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.STONE))
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
            .item(AssemblyOperatorBlockItem::new)
             // .removeTab(CreativeModeTabs.SEARCH)
            .transform(customItemModel())
            .register();

    /**
     * 手工台
     */
    public static final BlockEntry<?> CRAFTING_TABLE = REGISTRATE.block("crafting_table", CraftingTableBlocks::new)
            .item(AssemblyOperatorBlockItem::new)
            .transform(customItemModel())
            .register();

    /**
     * 动力筛分机
     */
    public static final BlockEntry<?> MECHANICAL_SCREENING = REGISTRATE.block("mechanical_screening", MechanicalScreeningBlock::new)
            .item(AssemblyOperatorBlockItem::new)
            .transform(customItemModel())
            .register();

    public static void register() {}
}
