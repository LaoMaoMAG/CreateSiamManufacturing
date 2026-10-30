package net.meownest.createsiammfg.client.renderer.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;


import net.meownest.createsiammfg.client.CSMPartialModels;
import net.meownest.createsiammfg.content.entity.SolderSuckerPushEntity;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@OnlyIn(Dist.CLIENT)
public class SolderSuckerPushEntityRenderer<T extends SolderSuckerPushEntity> extends ArrowRenderer<T> {
    private static final PartialModel PUSH = CSMPartialModels.SOLDER_SUCKER_PUSH;

    public SolderSuckerPushEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(
            T entity,
            float entityYaw,
            float partialTicks,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight
    ) {
        poseStack.pushPose();

        // 原版箭矢飞行方向
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

        // 原版受击抖动动画
        float shake = entity.shakeTime - partialTicks;

        if (shake > 0.0F) {
            float rotation = -Mth.sin(shake * 3.0F) * shake;
            poseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
        }

        // 原版箭矢轴向旋转
        poseStack.mulPose(Axis.XP.rotationDegrees(45.0F));

        // 门外竖着
        poseStack.mulPose(Axis.ZP.rotationDegrees(-90.0F));

        // 缩放和位置
        poseStack.scale(0.9F, 0.9F, 0.9F);
        poseStack.translate(-0.75F, -0.5F, -0.5F);

        // PartialModel
        SuperByteBuffer arrowBuffer = CachedBuffers.partial(PUSH, Blocks.AIR.defaultBlockState());
        arrowBuffer.light(packedLight).renderInto(poseStack, buffer.getBuffer(RenderType.cutoutMipped()));

        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}