package net.meownest.createsiammfg.registry;

import static net.meownest.createsiammfg.CreateSiamManufacturing.MOD_ID;
import net.meownest.createsiammfg.registry.item.CSMItems;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.neoforged.bus.api.IEventBus;

/**
 * 模组注册类
 */
public class CSMRegistrate {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static void register(IEventBus modEventBus) {
        REGISTRATE.registerEventListeners(modEventBus);
        CSMItems.register(modEventBus); // 注册物品
        CSMCreativeModeTab.register(modEventBus); // 注册创造模式标签
    }
}
