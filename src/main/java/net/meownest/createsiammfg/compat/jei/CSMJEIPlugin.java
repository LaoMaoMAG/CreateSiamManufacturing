package net.meownest.createsiammfg.compat.jei;

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import org.jetbrains.annotations.NotNull;

import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;

import net.meownest.createsiammfg.CreateSiamManufacturing;

import java.util.ArrayList;
import java.util.List;

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

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {

    }
}
