package net.meownest.createsiammfg;

import net.meownest.createsiammfg.registry.CSMRegistrate;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

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
     */
    public CreateSiamManufacturing(IEventBus modEventBus) {
        LOGGER.info("Create Siam Manufacturing is loading!");
        CSMRegistrate.register(modEventBus);
    }
}
