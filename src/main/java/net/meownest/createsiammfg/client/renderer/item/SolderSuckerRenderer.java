package net.meownest.createsiammfg.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.MultiBufferSource;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueHandler;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.registry.CSMItems;

@EventBusSubscriber(modid = CreateSiamManufacturing.MOD_ID, value = Dist.CLIENT)
public class SolderSuckerRenderer extends CustomRenderedItemModelRenderer {
    @SubscribeEvent
    @SuppressWarnings("unused")
    private static void register(RegisterClientExtensionsEvent event) {
        Item item = CSMItems.SOLDER_SUCKER.asItem();
        event.registerItem(SimpleCustomRenderer.create(item, new SolderSuckerRenderer()), item);
    }

    protected static final PartialModel GEAR = PartialModel.of(Create.asResource("item/wrench/gear"));

    @Override
    protected void render(
            ItemStack stack,
            CustomRenderedItemModel model,
            PartialItemModelRenderer renderer,
            ItemDisplayContext transformType,
            PoseStack ms,
            MultiBufferSource buffer,
            int light, int overlay
    ) {
        renderer.render(model.getOriginalModel(), light);

        float xOffset = -1 / 16f;
        ms.translate(-xOffset, 0, 0);
        ms.mulPose(Axis.YP.rotationDegrees(ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks())));
        ms.translate(xOffset, 0, 0);

        renderer.render(GEAR.get(), light);
    }
}
