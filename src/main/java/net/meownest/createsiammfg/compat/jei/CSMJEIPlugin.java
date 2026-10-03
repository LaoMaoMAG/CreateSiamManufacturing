package net.meownest.createsiammfg.compat.jei;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.content.processing.basin.BasinRecipe;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.compat.jei.category.MechanicalJuicingCategory;
import net.meownest.createsiammfg.registry.CSMBlocks;
import net.meownest.createsiammfg.registry.CSMRecipeTypes;





/**
 * CSM JEI 插件类
 */
@JeiPlugin
@SuppressWarnings("unused")
public class CSMJEIPlugin implements IModPlugin {
    private final List<CreateRecipeCategory<?>> modCategories = new ArrayList<>();

    @Override
    @NotNull
    public ResourceLocation getPluginUid() {
        return CreateSiamManufacturing.rl("jei_plugin");
    }

    private void loadCategories() {
        modCategories.clear();

        modCategories.add(
                new CreateRecipeCategory.Builder<>(BasinRecipe.class)
                        .addTypedRecipes(CSMRecipeTypes.JUICING)
                        .catalyst(CSMBlocks.MECHANICAL_JUICER::get)
                        .doubleItemIcon(CSMBlocks.MECHANICAL_JUICER.get(), AllBlocks.BASIN.get())
                        .emptyBackground(177, 103)
                        .build(CreateSiamManufacturing.rl("mechanical_juicer"), MechanicalJuicingCategory::new)
        );
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(modCategories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        modCategories.forEach(category -> category.registerRecipes(registration));
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        modCategories.forEach(category -> category.registerCatalysts(registration));
    }

    @Override
    public void registerRecipeTransferHandlers(@NotNull IRecipeTransferRegistration registration) {
    }
}