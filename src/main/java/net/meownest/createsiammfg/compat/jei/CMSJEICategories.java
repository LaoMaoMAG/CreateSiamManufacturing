package net.meownest.createsiammfg.compat.jei;

import java.util.List;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.content.processing.basin.BasinRecipe;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.compat.jei.category.MechanicalJuicingCategory;
import net.meownest.createsiammfg.registry.CSMBlocks;
import net.meownest.createsiammfg.registry.CSMRecipeTypes;

public class CMSJEICategories {
    public static final CreateRecipeCategory<BasinRecipe> MECHANICAL_JUICER =
            new CreateRecipeCategory.Builder<>(BasinRecipe.class)
                    .addTypedRecipes(CSMRecipeTypes.JUICING)
                    .catalyst(CSMBlocks.MECHANICAL_JUICER::get)
                    .doubleItemIcon(CSMBlocks.MECHANICAL_JUICER.get(), AllBlocks.BASIN.get())
                    .emptyBackground(177, 103)
                    .build(CreateSiamManufacturing.rl("mechanical_juicer"), MechanicalJuicingCategory::new);

    public static List<CreateRecipeCategory<?>> getCategories () {
        return List.of(
                MECHANICAL_JUICER
        );
    }
}
