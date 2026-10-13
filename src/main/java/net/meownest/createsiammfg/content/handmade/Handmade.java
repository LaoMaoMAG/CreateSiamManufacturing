package net.meownest.createsiammfg.content.handmade;

import net.minecraft.world.item.Item;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Handmade {
    private static final Set<Item> TOOL_SET = new HashSet<>();

    /**
     * 获取工具集合
     */
    public static Set<Item> getTools() {
        return Collections.unmodifiableSet(TOOL_SET);
    }

    /**
     * 添加工具
     */
    public static void addTool(Item item) {
        TOOL_SET.add(item);
    }

    /**
     * 移除工具
     */
    public static void removeTool(Item item) {
        TOOL_SET.remove(item);
    }

    /**
     * 是否为工具
     */
    public static boolean isTool(Item item) {
        return TOOL_SET.contains(item);
    }
}