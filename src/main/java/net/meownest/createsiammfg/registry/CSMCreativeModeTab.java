package net.meownest.createsiammfg.registry;

import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.meownest.createsiammfg.registry.block.CSMBlocks;
import net.meownest.createsiammfg.registry.item.CSMItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.mcexpanded.fancytabsections.FancyTabSections;

import net.meownest.createsiammfg.CreateSiamManufacturing;


public class CSMCreativeModeTab {
    public static ResourceLocation rl(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(CreateSiamManufacturing.MOD_ID, path);
    }

    /**
     * 注册创造模式标签
     *
     * @param modEventBus MOD 事件总线
     */
    public static void register(IEventBus modEventBus) {
        //register creative mode tab
        FancyTabSections.registerCreativeModeTab(modEventBus, rl("mod_tab"), CSMItems.ELECTRIC_SOLDERING_IRON);

        FancyTabSections.addSection(rl("mod_tab"),
                //identifier of the section
                new SectionColored(rl("tools"))
                        //title to display in the "empty row" (banner) of the section
                        //by default the title will use the translation key `section.[namespace].[path]`, just as shown here
                        .setTitle(Component.translatable("section."+CreateSiamManufacturing.MOD_ID+".tools"))
                        //background color of the "empty row" - ARGB
                        .setBannerColor(0xFF1a1a2e)
                        //text color - ARGB
                        .setTextColor(0xFFBBAA66)
                        //text shadow
                        .setTextShadow(true)

                        //adds an item
                        .add(CSMItems.SOLDERING_IRON)
                        .add(CSMItems.ELECTRIC_SOLDERING_IRON)
                        .add(CSMItems.ADVANCED_SOLDERING_IRON)
                        .add(CSMItems.SOLDER_SUCKER)


        );

        FancyTabSections.addSection(rl("mod_tab"),
                //identifier of the section
                new SectionColored(rl("material"))
                        //title to display in the "empty row" (banner) of the section
                        //by default the title will use the translation key `section.[namespace].[path]`, just as shown here
                        .setTitle(Component.translatable("section."+CreateSiamManufacturing.MOD_ID+".material"))
                        //background color of the "empty row" - ARGB
                        .setBannerColor(0xFF1a1a2e)
                        //text color - ARGB
                        .setTextColor(0xFFBBAA66)
                        //text shadow
                        .setTextShadow(true)

                        //adds an item
                        .add(CSMItems.BLADE_HEAD)
                        .add(CSMItems.SOLDER_WIRE)
                        .add(CSMItems.ROSIN)


        );

        FancyTabSections.addSection(rl("mod_tab"),
                //identifier of the section
                new SectionColored(rl("machine"))
                        //title to display in the "empty row" (banner) of the section
                        .setTitle(Component.translatable("section."+CreateSiamManufacturing.MOD_ID+".machine"))
                        //background color of the "empty row" - ARGB
                        .setBannerColor(0xFF1a1a2e)
                        //text color - ARGB
                        .setTextColor(0xFFBBAA66)
                        //text shadow
                        .setTextShadow(true)

                        //adds a block
                        .add(CSMBlocks.MECHANICAL_JUICER)
                        .add(CSMBlocks.CRAFTING_TABLE)
                        .add(CSMBlocks.MECHANICAL_SCREENING)

        );

    }
}
