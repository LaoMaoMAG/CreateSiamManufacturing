package net.meownest.createsiammfg.compat.jei.category.animations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;

import net.createmod.catnip.animation.AnimationTickHolder;
import net.meownest.createsiammfg.registry.CSMBlocks;
import net.meownest.createsiammfg.registry.CSMPartialModels;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

/*
 * 榨汁机动画
 */
public class AnimatedJuicer extends AnimatedKinetics {

    @Override
    public void draw(GuiGraphics graphics, int xOffset, int yOffset) {
        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        matrixStack.translate(xOffset, yOffset, 200);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-15.5f));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5f));

        int scale = 23;

        // 齿轮
        blockElement(cogwheel())
                .rotateBlock(0, getCurrentAngle() * 2, 0)
                .atLocal(0, 0, 0)
                .scale(scale)
                .render(graphics);

        // 榨汁机方块
        blockElement(CSMBlocks.MECHANICAL_JUICER.getDefaultState())
                .atLocal(0, 0, 0)
                .scale(scale)
                .render(graphics);

        // 榨汁机运动杆
        float animation = ((Mth.sin(AnimationTickHolder.getRenderTime() / 32f) + 1) / 5) + .5f;

        blockElement(AllPartialModels.MECHANICAL_MIXER_POLE)
                .atLocal(0, animation, 0)
                .scale(scale)
                .render(graphics);

        // 榨汁机刀头
        blockElement(CSMPartialModels.MECHANICAL_JUICER_HEAD)
                .rotateBlock(0, getCurrentAngle() * 4, 0)
                .atLocal(0, animation, 0)
                .scale(scale)
                .render(graphics);

        // 工作盆
        blockElement(AllBlocks.BASIN.getDefaultState())
                .atLocal(0, 1.65, 0)
                .scale(scale)
                .render(graphics);
        
        matrixStack.popPose();
    }
}