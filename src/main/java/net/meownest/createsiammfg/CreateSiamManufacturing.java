package net.meownest.createsiammfg;

import net.meownest.createsiammfg.registry.CSMRegistrate;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

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
        CSMRegistrate.register(modEventBus);
    }
}
