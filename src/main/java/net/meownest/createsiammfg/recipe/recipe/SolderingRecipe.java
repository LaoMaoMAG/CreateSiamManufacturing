package net.meownest.createsiammfg.recipe.recipe;

import java.util.List;

import com.mojang.serialization.MapCodec;

import net.meownest.createsiammfg.recipe.CSMRecipeTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;

import net.meownest.createsiammfg.recipe.params.SolderingRecipeParams;

/**
 * 焊接配方
 */
public class SolderingRecipe extends ProcessingRecipe<RecipeInput, SolderingRecipeParams> {

    public SolderingRecipe(SolderingRecipeParams params) {
        super(CSMRecipeTypes.SOLDERING, params);
    }

    public float getFailureChance() {
        return params.getFailureChance();
    }

    public List<ProcessingOutput> getFailureResults() {
        return params.getFailureResults();
    }

    public int getSolderingCount() {
        return params.getSolderingCount();
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 1;
    }

    /**
     * 输入是否匹配
     */
    @Override
    public boolean matches(RecipeInput input, Level level) {
        return !input.isEmpty()
                && input.size() == 1
                && ingredients.size() == 1
                && ingredients.get(0).test(input.getItem(0));
    }

    public static class Serializer implements RecipeSerializer<SolderingRecipe> {

        private final MapCodec<SolderingRecipe> codec;

        private final StreamCodec<RegistryFriendlyByteBuf, SolderingRecipe> streamCodec;

        public Serializer(ProcessingRecipe.Factory<SolderingRecipeParams, SolderingRecipe> factory) {
            codec = ProcessingRecipe.codec(factory, SolderingRecipeParams.CODEC);
            streamCodec = ProcessingRecipe.streamCodec(factory, SolderingRecipeParams.STREAM_CODEC);
        }

        @Override
        public MapCodec<SolderingRecipe> codec() {
            return codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SolderingRecipe> streamCodec() {
            return streamCodec;
        }
    }
}