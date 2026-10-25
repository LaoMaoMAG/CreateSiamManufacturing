package net.meownest.createsiammfg.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
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
import net.meownest.createsiammfg.client.CSMPartialModels;
import net.meownest.createsiammfg.registry.CSMItems;
import net.meownest.createsiammfg.content.item.solder_sucker.SolderSuckerItem;

@EventBusSubscriber(modid = CreateSiamManufacturing.MOD_ID, value = Dist.CLIENT)
public class SolderSuckerRenderer extends CustomRenderedItemModelRenderer {
    private static final PartialModel TUBE = CSMPartialModels.SOLDER_SUCKER_TUBE;
    private static final PartialModel PUSH = CSMPartialModels.SOLDER_SUCKER_PUSH;
    private static final PartialModel GUI_0 = CSMPartialModels.SOLDER_SUCKER_GUI_0;
    private static final PartialModel GUI_1 = CSMPartialModels.SOLDER_SUCKER_GUI_1;
    private static final PartialModel GUI_2 = CSMPartialModels.SOLDER_SUCKER_GUI_2;
    private static final PartialModel GUI_3 = CSMPartialModels.SOLDER_SUCKER_GUI_3;
    private static final PartialModel GUI_TUBE = CSMPartialModels.SOLDER_SUCKER_GUI_TUBE;

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
        if (transformType == ItemDisplayContext.GUI) {
            BakedModel guiModel;

            if (!SolderSuckerItem.isFire(stack)) {
                int stage = SolderSuckerItem.isReady(stack) ? 3 : getChargeStage(stack);
                guiModel = switch (stage) {
                    case 1 -> GUI_1.get();
                    case 2 -> GUI_2.get();
                    case 3 -> GUI_3.get();
                    default -> GUI_0.get();
                };
            } else guiModel = GUI_TUBE.get();

            renderer.render(guiModel, light);
            return;
        }

        if (!SolderSuckerItem.isFire(stack)) {
            float progress = getChargeProgress(stack);
            float offset = progress * (3.5f / 16.0f);
            ms.pushPose();
            ms.translate(0.0, -offset, 0.0);
            renderer.render(PUSH.get(), light);
            ms.popPose();
        }

        renderer.render(TUBE.get(), light);
    }

    private static int getChargeStage(ItemStack stack) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || player.getUseItem() != stack) return 0;
        int chargeTicks = player.getTicksUsingItem();
        if (chargeTicks >= SolderSuckerItem.CHARGE_TICKS) return 3;
        if (chargeTicks >= SolderSuckerItem.CHARGE_TICKS / 2) return 2;
        return chargeTicks > 0 ? 1 : 0;
    }

    private static float getChargeProgress(ItemStack stack) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (SolderSuckerItem.isReady(stack)) return 1.0f;
        if (player == null || player.getUseItem() != stack) return 0.0f;
        float chargeTicks = player.getTicksUsingItem() + Mth.frac(AnimationTickHolder.getRenderTime());
        return Mth.clamp(chargeTicks / SolderSuckerItem.CHARGE_TICKS, 0.0f, 1.0f);
    }
}