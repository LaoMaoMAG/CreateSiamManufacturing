package net.meownest.createsiammfg.registry;

import java.util.Locale;
import java.util.function.Supplier;

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
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;

import net.meownest.createsiammfg.CreateSiamManufacturing;
import net.meownest.createsiammfg.recipe.JuicingRecipe;
import net.meownest.createsiammfg.recipe.SolderingRecipe;
import net.meownest.createsiammfg.recipe.params.SolderingRecipeParams;

public enum CSMRecipeTypes  implements IRecipeTypeInfo {
    // ===== 配方类型枚举 =====

    /**
     * 榨汁配方
     */
    JUICING(JuicingRecipe::new),

    /**
     * 焊接配方
     */
    SOLDERING(SolderingRecipe::new);

    // ===== 配方类型属性 =====

    /**
     * 配方类型资源 ID
     */
    public final ResourceLocation id;

    /**
     * 配方序列化器 DeferredHolder
     */
    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializer;

    /**
     * 配方类型 DeferredHolder
     */
    private final DeferredHolder<RecipeType<?>, RecipeType<?>> type;

    /**
     * Create 标准加工配方
     */
    CSMRecipeTypes(StandardProcessingRecipe.Factory<?> factory) {
        this(() -> new StandardProcessingRecipe.Serializer<>(factory));
    }

    /**
     * 焊接自定义参数配方
     */
    CSMRecipeTypes(ProcessingRecipe.Factory<SolderingRecipeParams, SolderingRecipe> factory) {
        this(() -> new SolderingRecipe.Serializer(factory));
    }

    /**
     * 通用序列化器注册入口
     */
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



    /**
     * 注册
     */
    public static void register(IEventBus bus) {
        Registers.SERIALIZERS.register(bus);
        Registers.TYPES.register(bus);
    }

    // ===== IRecipeTypeInfo 接口实现 =====

    /**
     * 返回配方 ID
     */
    @Override
    public ResourceLocation getId() {
        return id;
    }

    /**
     * 返回配方序列化器实例
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializer.get();
    }

    /**
     * 返回配方类型实例
     */
    @Override
    @SuppressWarnings("unchecked")
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    // ===== 内部静态类 =====

    private static class Registers {
        // 配方序列化器注册器
        static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
                DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateSiamManufacturing.MOD_ID);
        // 配方类型注册器
        static final DeferredRegister<RecipeType<?>> TYPES =
                DeferredRegister.create(Registries.RECIPE_TYPE, CreateSiamManufacturing.MOD_ID);
    }
}
