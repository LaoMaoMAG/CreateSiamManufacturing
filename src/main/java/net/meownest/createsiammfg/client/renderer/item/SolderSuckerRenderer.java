package net.meownest.createsiammfg.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.registry.CSMPartialModels;
import net.meownest.createsiammfg.registry.CSMItems;

@EventBusSubscriber(modid = CreateSiamManufacturing.MOD_ID, value = Dist.CLIENT)
public class SolderSuckerRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel TUBE = CSMPartialModels.SOLDER_SUCKER_TUBE;
    protected static final PartialModel PUSH = CSMPartialModels.SOLDER_SUCKER_PUSH;

    @SubscribeEvent
    @SuppressWarnings("unused")
    private static void register(RegisterClientExtensionsEvent event) {
        Item item = CSMItems.SOLDER_SUCKER.asItem();
        event.registerItem(SimpleCustomRenderer.create(item, new SolderSuckerRenderer()), item);
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
        float time = AnimationTickHolder.getRenderTime();
        float offset = (Mth.sin(time * 0.15f) + 1.0f) * 0.5f * (4.0f / 16.0f);

        ms.pushPose();
        ms.translate(0.0, -offset, 0.0);
        renderer.render(PUSH.get(), light);
        ms.popPose();

        renderer.render(TUBE.get(), light);
    }
}