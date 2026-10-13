package net.meownest.createsiammfg.content.handmade;

import net.minecraft.world.item.Item;

import java.util.List;

public class Handmade {
    private static List<Item> toolList = List.of();

    public static List<Item> getToolList() {
        return toolList;
    }

    public static void addTool(Item item) {
        toolList.add(item);
    }

    public static void removeTool(Item item) {
        toolList.remove(item);
    }

    
    public static boolean isTool(Item item) {
        return toolList.contains(item);
    }
}
