package net.meownest.createsiammfg.client;

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

    public static final PartialModel SOLDER_SUCKER_GUI_0 = item("solder_sucker/gui_0");
    public static final PartialModel SOLDER_SUCKER_GUI_1 = item("solder_sucker/gui_1");
    public static final PartialModel SOLDER_SUCKER_GUI_2 = item("solder_sucker/gui_2");
    public static final PartialModel SOLDER_SUCKER_GUI_3 = item("solder_sucker/gui_3");
    public static final PartialModel SOLDER_SUCKER_GUI_TUBE = item("solder_sucker/gui_tube");

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
