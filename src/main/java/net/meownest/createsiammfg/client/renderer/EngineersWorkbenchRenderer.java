package net.meownest.createsiammfg.client.renderer;

import java.util.Random;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import com.simibubi.create.content.logistics.depot.DepotRenderer;

import net.meownest.createsiammfg.content.block.engineersWorkbench.EngineersWorkbenchBlocksEntity;


public class EngineersWorkbenchRenderer implements BlockEntityRenderer<EngineersWorkbenchBlocksEntity> {

    public EngineersWorkbenchRenderer(BlockEntityRendererProvider.Context ignoredContext) {
    }

    @Override
    public void render(
            EngineersWorkbenchBlocksEntity be,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            int packedOverlay
    ) {
        ItemStack stack = be.getHeldItem();

        if (stack.isEmpty()) {
            return;
        }

        BlockPos pos = be.getBlockPos();

        poseStack.pushPose();

        poseStack.translate(0.5f, 15 / 16f, 0.5f);

        DepotRenderer.renderItem(
                poseStack,
                buffer,
                packedLight,
                packedOverlay,
                stack,
                0,
                new Random(0),
                Vec3.atCenterOf(pos),
                false
        );

        poseStack.popPose();
    }
}