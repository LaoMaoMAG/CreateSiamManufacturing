package net.meownest.createsiammfg.registry;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import com.simibubi.create.foundation.data.CreateRegistrate;

import net.meownest.createsiammfg.content.item.HammerItem;
import net.meownest.createsiammfg.content.item.SolderSuckerItem;
import net.meownest.createsiammfg.content.item.soldering_iron.SolderingIronItem;
import net.meownest.createsiammfg.content.item.soldering_iron.ElectricSolderingIron;

/**
 * CSM 物品注册表
 */
public class CSMItems {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    /**
     * 刀头
     */
    public static final ItemEntry<Item> BLADE_HEAD = REGISTRATE
            .item("blade_head", Item::new)
            .register();

    /**
     * 烙铁
     */
    public static final ItemEntry<SolderingIronItem> SOLDERING_IRON = REGISTRATE
            .item("soldering_iron", SolderingIronItem::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 电烙铁
     */
    public static final ItemEntry<ElectricSolderingIron> ELECTRIC_SOLDERING_IRON = REGISTRATE
            .item("electric_soldering_iron", ElectricSolderingIron::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 高级电烙铁
     */
    public static final ItemEntry<Item> ADVANCED_SOLDERING_IRON = REGISTRATE
            .item("advanced_soldering_iron", Item::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 吸锡器
     */
    public static final ItemEntry<SolderSuckerItem> SOLDER_SUCKER = REGISTRATE
            .item("solder_sucker", SolderSuckerItem::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 焊锡丝
     */
    public static final ItemEntry<Item> SOLDER_WIRE = REGISTRATE
            .item("solder_wire", Item::new)
            .register();

    /**
     * 松香
     */
    public static final ItemEntry<Item> ROSIN = REGISTRATE
            .item("rosin", Item::new)
            .register();

    /**
     * 锤子
     */
    public static final ItemEntry<HammerItem> HAMMER = REGISTRATE
            .item("hammer", HammerItem::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 螺丝刀
     */
    public static final ItemEntry<Item> SCREWDRIVER = REGISTRATE
            .item("screwdriver", Item::new)
            .properties(p -> p.stacksTo(1))
            .register();

    /**
     * 弹簧
     */
    public static final ItemEntry<Item> SPRING = REGISTRATE
            .item("spring", Item::new)
            .register();

    /**
     * 物品注册
     */
    public static void register() {

    }
}
