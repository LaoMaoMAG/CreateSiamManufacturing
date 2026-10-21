package net.meownest.createsiammfg.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;

import net.meownest.createsiammfg.CreateSiamManufacturing;

/**
 * CSM 模型注册类
 */
public class CSMPartialModels {
    /**
     * 动力榨汁机刀头
     */
    public static final PartialModel MECHANICAL_JUICER_HEAD = block("mechanical_juicer/head");

    /**
     * 吸锡器推杆
     */
    public static final PartialModel SOLDER_SUCKER_PUSH = item("solder_sucker/push");

    /**
     * 吸锡器圆筒
     */
    public static final PartialModel SOLDER_SUCKER_TUBE = item("solder_sucker/tube");

    private static PartialModel block(String path) {
        return PartialModel.of(CreateSiamManufacturing.rl("block/" + path));
    }

    private static PartialModel item(String path) {
        return PartialModel.of(CreateSiamManufacturing.rl("item/" + path));
    }

    public static void init() {
        // 初始化静态字段
    }
}
