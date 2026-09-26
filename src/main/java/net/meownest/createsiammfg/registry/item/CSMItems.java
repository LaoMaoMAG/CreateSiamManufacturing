package net.meownest.createsiammfg.registry.item;

import net.meownest.createsiammfg.CreateSiamManufacturing;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * CSM 物品注册表
 */
public class CSMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateSiamManufacturing.MOD_ID);

    /**
     * 刀头
     */
    public static final DeferredItem<Item> BLADE_HEAD = ITEMS.registerSimpleItem("blade_head");

    /**
     * 烙铁
     */
    public static final DeferredItem<Item> SOLDERING_IRON = ITEMS.registerSimpleItem("soldering_iron");

    /**
     * 热烙铁
     */
    public static final DeferredItem<Item> HOT_SOLDERING_IRON = ITEMS.registerSimpleItem("hot_soldering_iron");

    /**
     * 电烙铁
     */
    public static final DeferredItem<Item> ELECTRIC_SOLDERING_IRON = ITEMS.registerSimpleItem("electric_soldering_iron");

    /**
     * 高级电烙铁
     */
    public static final DeferredItem<Item> ADVANCED_SOLDERING_IRON = ITEMS.registerSimpleItem("advanced_soldering_iron");

    /**
     * 吸锡器
     */
     public static final DeferredItem<Item> SOLDER_SUCKER = ITEMS.registerSimpleItem("solder_sucker");

     /**
      * 焊锡丝
      */
     public static final DeferredItem<Item> SOLDER_WIRE = ITEMS.registerSimpleItem("solder_wire");

     /**
      * 松香
      */
     public static final DeferredItem<Item> ROSIN = ITEMS.registerSimpleItem("rosin");

    /**
     * 物品注册
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
