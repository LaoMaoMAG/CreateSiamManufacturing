package net.meownest.createsiammfg.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.client.CSMPartialModels;
import net.meownest.createsiammfg.registry.CSMItems;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = CreateSiamManufacturing.MOD_ID, value = Dist.CLIENT)
public class ElectricSolderingIronRenderer extends CustomRenderedItemModelRenderer {
    private static final PartialModel ITEM = CSMPartialModels.ELECTRIC_SOLDERING_IRON_ITEM;
    private static final PartialModel MODEL = CSMPartialModels.ELECTRIC_SOLDERING_IRON_MODEL;

    @SubscribeEvent
    @SuppressWarnings("unused")
    private static void register(RegisterClientExtensionsEvent event) {
        Item item = CSMItems.ELECTRIC_SOLDERING_IRON.asItem();
        event.registerItem(SimpleCustomRenderer.create(item, new ElectricSolderingIronRenderer()), item);
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
        if (transformType == ItemDisplayContext.GUI)
            guiRenderer(renderer, light);
        else
            modelRenderer(renderer, light);
    }

    private void guiRenderer(PartialItemModelRenderer renderer, int light) {
        renderer.render(ITEM.get(), light);
    }

    private void modelRenderer(PartialItemModelRenderer renderer, int light) {
        renderer.render(MODEL.get(), light);
    }
}
