package net.meownest.createsiammfg.content.block.kinetics.juicer;

import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;

import net.meownest.createsiammfg.registry.CSMRecipeTypes;

/**
 * 榨汁配方，继承 BasinRecipe(工作盆)
 */
public class JuicingRecipe extends BasinRecipe {
    public JuicingRecipe(ProcessingRecipeParams params) {
        super(CSMRecipeTypes.JUICING, params);
    }
}

