package net.meownest.createsiammfg.registry.item;

import net.meownest.createsiammfg.CreateSiamManufacturing;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * CSM 物品注册表
 */
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateSiamManufacturing.MOD_ID);

    /** 刀头 */
    @SuppressWarnings("unused")
    public static final DeferredItem<Item> BLADE_HEAD = ITEMS.registerSimpleItem("blade_head");

    /** 物品注册 */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
