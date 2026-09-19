package net.meownest.createsiammfg;

import net.meownest.createsiammfg.registry.ModCreativeModeTab;
import net.meownest.createsiammfg.registry.item.ModItems;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

import org.slf4j.Logger;

/**
 * 模组主类
 */
@Mod(CreateSiamManufacturing.MOD_ID)
public class CreateSiamManufacturing {
    /**
     * 模组 ID
     */
    public static final String MOD_ID = "createsiammfg";

    /**
     * 日志记录器
     */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * 初始化模组
     *
     * @param modEventBus  模组事件总线
     * @param modContainer 模组容器
     */
    public CreateSiamManufacturing(IEventBus modEventBus, ModContainer modContainer) {
        // 内容注册部分
        ModItems.register(modEventBus); // 注册物品
        ModCreativeModeTab.register(modEventBus); // 注册创造模式标签
    }
}
