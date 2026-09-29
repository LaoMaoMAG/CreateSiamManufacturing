package net.meownest.createsiammfg.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.minecraft.resources.ResourceLocation;

/**
 * CSM 模型注册类
 */
public class CSMPartialModels {
    /**
     * 动力榨汁机刀头
     */
    public static final PartialModel MECHANICAL_JUICER_HEAD = block("mechanical_juicer/head");

    private static PartialModel block(String path) {
        return PartialModel.of(ResourceLocation.fromNamespaceAndPath(CreateSiamManufacturing.MOD_ID, "block/" + path));
    }

    public static void init() {
        // 初始化静态字段
    }
}
