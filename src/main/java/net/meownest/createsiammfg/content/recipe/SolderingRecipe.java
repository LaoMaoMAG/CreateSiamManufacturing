package net.meownest.createsiammfg.content.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.meownest.createsiammfg.registry.CSMRecipeTypes;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

/**
 * 焊接配方类
 */
public class SolderingRecipe extends StandardProcessingRecipe<RecipeInput> {
    public SolderingRecipe(ProcessingRecipeParams params) {
        super(CSMRecipeTypes.SOLDERING, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 0;
    }

    @Override
    protected int getMaxOutputCount() {
        return 0;
    }
    
    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return false;
    }
}
