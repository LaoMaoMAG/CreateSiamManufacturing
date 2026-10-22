package net.meownest.createsiammfg.registry;

import net.neoforged.bus.api.IEventBus;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionAnimatedTextured;

import net.meownest.createsiammfg.CreateSiamManufacturing;


public class CSMCreativeModeTab {
    /**
     * 注册创造模式标签
     *
     * @param modEventBus MOD 事件总线
     */
    public static void register(IEventBus modEventBus) {
        FancyTabSections.registerCreativeModeTab(
                modEventBus,
                CreateSiamManufacturing.rl("mod_tab"),
                () -> CSMItems.ELECTRIC_SOLDERING_IRON.get().getDefaultInstance()
        );

        // 工具
        FancyTabSections.addSection(CreateSiamManufacturing.rl("mod_tab"),
                new SectionAnimatedTextured(CreateSiamManufacturing.rl("tools"))
                        .setFrames(8)
                        .setFrameTimeInMS(200)
                        .setCollapsible(false)
                        .setTextColor(0xFFFFFF)
                        .setTextShadow(true)

                        .add(CSMItems.SOLDERING_IRON)
                        .add(CSMItems.ELECTRIC_SOLDERING_IRON)
                        .add(CSMItems.ADVANCED_SOLDERING_IRON)
                        .add(CSMItems.SOLDER_SUCKER)
                        .add(CSMItems.HAMMER)
                        .add(CSMItems.SCREWDRIVER)
        );

        // 材料
        FancyTabSections.addSection(CreateSiamManufacturing.rl("mod_tab"),
                new SectionAnimatedTextured(CreateSiamManufacturing.rl("material"))
                        .setFrames(8)
                        .setFrameTimeInMS(200)
                        .setCollapsible(false)
                        .setTextColor(0xFFFFFF)
                        .setTextShadow(true)

                        .add(CSMItems.BLADE_HEAD)
                        .add(CSMItems.SOLDER_WIRE)
                        .add(CSMItems.ROSIN)
                        .add(CSMItems.SPRING)
                        .add(CSMItems.SOLDER_SUCKER_PUSH)
        );

        // 机器
        FancyTabSections.addSection(CreateSiamManufacturing.rl("mod_tab"),
                new SectionAnimatedTextured(CreateSiamManufacturing.rl("machine"))
                        .setFrames(4)
                        .setFrameTimeInMS(200)
                        .setCollapsible(false)
                        .setTextColor(0xFFFFFF)
                        .setTextShadow(true)

                        .add(CSMBlocks.MECHANICAL_JUICER)
                        .add(CSMBlocks.ENGINEERS_WORKBENCH)
                        .add(CSMBlocks.MECHANICAL_SCREENING)
        );
    }
}
