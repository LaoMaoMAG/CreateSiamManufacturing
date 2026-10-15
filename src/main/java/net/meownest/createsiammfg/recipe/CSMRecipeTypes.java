package net.meownest.createsiammfg.recipe;

import java.util.Locale;
import java.util.function.Supplier;

import net.meownest.createsiammfg.recipe.recipe.DismantleSolderingRecipe;
import net.meownest.createsiammfg.recipe.recipe.JuicingRecipe;
import net.meownest.createsiammfg.recipe.recipe.SolderingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

import net.meownest.createsiammfg.CreateSiamManufacturing;


/**
 * CSM 配方类型
 */
public enum CSMRecipeTypes implements IRecipeTypeInfo {
    /**
     * 榨汁配方
     */
    JUICING(() -> new StandardProcessingRecipe.Serializer<>(JuicingRecipe::new)),

    /**
     * 焊接配方
     */
    SOLDERING(() -> new SolderingRecipe.Serializer(SolderingRecipe::new)),

    /**
     * 拆接配方
     */
    DISMANTLE_SOLDERING(() -> new DismantleSolderingRecipe.Serializer(DismantleSolderingRecipe::new));

    public final ResourceLocation id;

    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializer;

    private final DeferredHolder<RecipeType<?>, RecipeType<?>> type;

    CSMRecipeTypes(Supplier<? extends RecipeSerializer<?>> serializerFactory) {
        this.id = CreateSiamManufacturing.rl(
                name().toLowerCase(Locale.ROOT)
        );

        this.serializer = Registers.SERIALIZERS.register(
                name().toLowerCase(Locale.ROOT),
                serializerFactory
        );

        this.type = Registers.TYPES.register(
                name().toLowerCase(Locale.ROOT),
                () -> RecipeType.simple(id)
        );
    }

    public static void register(IEventBus bus) {
        Registers.SERIALIZERS.register(bus);
        Registers.TYPES.register(bus);
    }

    /**
     * 返回配方 ID
     */
    @Override
    public ResourceLocation getId() {
        return id;
    }

    /**
     * 返回配方序列化器
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializer.get();
    }

    /**
     * 返回配方类型
     */
    @Override
    @SuppressWarnings("unchecked")
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    private static class Registers {
        static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
                DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateSiamManufacturing.MOD_ID);
        static final DeferredRegister<RecipeType<?>> TYPES =
                DeferredRegister.create(Registries.RECIPE_TYPE, CreateSiamManufacturing.MOD_ID);
    }
}