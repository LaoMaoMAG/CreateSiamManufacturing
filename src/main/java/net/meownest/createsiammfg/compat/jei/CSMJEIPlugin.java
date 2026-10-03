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

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;

import net.meownest.createsiammfg.CreateSiamManufacturing;


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

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        modCategories.clear();
        modCategories.addAll(CSMJEICategories.getCategories());
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