package net.meownest.createsiammfg.registry;

import java.util.Locale;

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
import net.meownest.createsiammfg.content.block.kinetics.juicer.JuicingRecipe;

public enum CSMRecipeTypes  implements IRecipeTypeInfo {
    // ===== 配方类型枚举 =====

    /**
     * 动力榨汁机配方
     */
    JUICING(JuicingRecipe::new);

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
     * 枚举构造器
     */
    CSMRecipeTypes(StandardProcessingRecipe.Factory<?> factory) {
        // 设置配方资源 ID
        this.id = CreateSiamManufacturing.rl(name().toLowerCase(Locale.ROOT));

        // 注册配方序列化器
        // 使用 Create 的 StandardProcessingRecipe.Serializer
        this.serializer = Registers.SERIALIZERS.register(name().toLowerCase(Locale.ROOT),
                () -> new StandardProcessingRecipe.Serializer<>(factory));
        // 注册配方类型
        this.type = Registers.TYPES.register(name().toLowerCase(Locale.ROOT),
                () -> RecipeType.simple(id));
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
