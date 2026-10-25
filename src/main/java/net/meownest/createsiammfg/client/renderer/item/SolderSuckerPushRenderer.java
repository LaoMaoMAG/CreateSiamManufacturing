package net.meownest.createsiammfg.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.registry.CSMItems;

@EventBusSubscriber(modid = CreateSiamManufacturing.MOD_ID, value = Dist.CLIENT)
public class SolderSuckerPushRenderer extends CustomRenderedItemModelRenderer {
    @SubscribeEvent
    @SuppressWarnings("unused")
    private static void register(RegisterClientExtensionsEvent event) {
        Item item = CSMItems.SOLDER_SUCKER_PUSH.asItem();
        event.registerItem(SimpleCustomRenderer.create(item, new SolderSuckerPushRenderer()), item);
    }

    @Override
    protected void render(
            ItemStack stack,
            CustomRenderedItemModel model,
            PartialItemModelRenderer renderer,
            ItemDisplayContext transformType,
            PoseStack ms,
            MultiBufferSource buffer,
            int light,
            int overlay
    ) {

    }
}
