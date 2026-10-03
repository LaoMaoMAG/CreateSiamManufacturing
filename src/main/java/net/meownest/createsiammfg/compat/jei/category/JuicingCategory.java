package net.meownest.createsiammfg.compat.jei.category;

import com.simibubi.create.compat.jei.category.BasinCategory;
import com.simibubi.create.content.processing.basin.BasinRecipe;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;

import net.meownest.createsiammfg.compat.jei.category.animations.AnimatedJuicer;

import net.minecraft.client.gui.GuiGraphics;

import javax.annotation.ParametersAreNonnullByDefault;

/*
* 榨汁机 Category 类
*/
@ParametersAreNonnullByDefault
public class JuicingCategory extends BasinCategory {
    private final AnimatedJuicer juicer = new AnimatedJuicer();

    public JuicingCategory(Info<BasinRecipe> info) {
        super(info, false);
    }

    @Override
    public void draw(
            BasinRecipe recipe,
            IRecipeSlotsView recipeSlotsView,
            GuiGraphics graphics,
            double mouseX,
            double mouseY
    ) {
        super.draw(
                recipe,
                recipeSlotsView,
                graphics,
                mouseX,
                mouseY
        );

        juicer.draw(
                graphics,
                getBackground().getWidth() / 2 + 3,
                34
        );
    }
}