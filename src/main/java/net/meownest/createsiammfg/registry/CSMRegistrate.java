package net.meownest.createsiammfg.registry;

import static net.meownest.createsiammfg.CreateSiamManufacturing.MOD_ID;

import net.meownest.createsiammfg.registry.block.CSMBlocks;
import net.meownest.createsiammfg.registry.blockEntry.CSMBlockEntities;
import net.meownest.createsiammfg.registry.item.CSMItems;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;

/**
 * 模组注册类
 */
public class CSMRegistrate {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public static void register(IEventBus modEventBus) {
        CSMBlocks.register(); // 注册方块
        CSMBlockEntities.register(); // 注册方块实体
        CSMItems.register(modEventBus); // 注册物品
        CSMCreativeModeTab.register(modEventBus); // 注册创造模式标签
        REGISTRATE.registerEventListeners(modEventBus);
        CSMRecipeTypes.register(modEventBus); // 注册配方类型
    }
}
