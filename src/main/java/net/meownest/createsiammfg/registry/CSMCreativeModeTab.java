package net.meownest.createsiammfg.registry;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.registry.block.CSMBlocks;
import net.meownest.createsiammfg.registry.item.CSMItems;

import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;

import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionAnimatedTextured;


public class CSMCreativeModeTab {
    /**
     * 注册创造模式标签
     *
     * @param modEventBus MOD 事件总线
     */
    public static void register(IEventBus modEventBus) {
        FancyTabSections.registerCreativeModeTab(modEventBus, CreateSiamManufacturing.rl("mod_tab"), CSMItems.ELECTRIC_SOLDERING_IRON);

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
        );

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
        );

        FancyTabSections.addSection(CreateSiamManufacturing.rl("mod_tab"),
                new SectionAnimatedTextured(CreateSiamManufacturing.rl("machine"))
                        .setFrames(4)
                        .setFrameTimeInMS(200)
                        .setCollapsible(false)
                        .setTextColor(0xFFFFFF)
                        .setTextShadow(true)

                        .add(CSMBlocks.MECHANICAL_JUICER)
                        .add(CSMBlocks.CRAFTING_TABLE)
                        .add(CSMBlocks.MECHANICAL_SCREENING)
        );
    }
}
