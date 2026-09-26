package net.meownest.createsiammfg.registry;

import net.meownest.createsiammfg.registry.block.CSMBlocks;
import net.meownest.createsiammfg.registry.item.CSMItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.meownest.createsiammfg.CreateSiamManufacturing.MOD_ID;

public class CSMCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    /**
     * 模组主创造栏
     */
    @SuppressWarnings("unused")
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB =
            CREATIVE_MODE_TABS.register("mod_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MOD_ID + ".mod_tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> CSMItems.BLADE_HEAD.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        output.accept(CSMItems.BLADE_HEAD.get());
                        output.accept(CSMItems.SOLDERING_IRON.get());
                        output.accept(CSMItems.HOT_SOLDERING_IRON.get());
                        output.accept(CSMItems.ELECTRIC_SOLDERING_IRON.get());
                        output.accept(CSMItems.ADVANCED_SOLDERING_IRON.get());
                        output.accept(CSMItems.SOLDER_SUCKER.get());
                        output.accept(CSMItems.SOLDER_WIRE.get());
                        output.accept(CSMItems.ROSIN.get());

                    }).build());

    /**
     * 注册创造模式标签
     *
     * @param modEventBus MOD 事件总线
     */
    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
