package net.meownest.createsiammfg.recipe.recipe;

import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import net.meownest.createsiammfg.recipe.CSMRecipeTypes;
import net.meownest.createsiammfg.recipe.params.DismantleSolderingRecipeParams;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

/**
 * 拆焊配方类
 */
public class DismantleSolderingRecipe extends ProcessingRecipe<RecipeInput, DismantleSolderingRecipeParams> {
    public DismantleSolderingRecipe(DismantleSolderingRecipeParams params) {
        super(CSMRecipeTypes.DISMANTLE_SOLDERING, params);
    }
    @Override
    public int getMaxInputCount() {
        return 0;
    }
    @Override
    public int getMaxOutputCount() {
        return 0;
    }

    @Override
    public boolean matches(RecipeInput input, Level level) {
        return false;
    }

    public static class Serializer implements RecipeSerializer<DismantleSolderingRecipe> {
        private final MapCodec<DismantleSolderingRecipe> codec;

        private final StreamCodec<RegistryFriendlyByteBuf, DismantleSolderingRecipe> streamCodec;

        public Serializer(ProcessingRecipe.Factory<DismantleSolderingRecipeParams, DismantleSolderingRecipe> factory) {
            codec = ProcessingRecipe.codec(factory, DismantleSolderingRecipeParams.CODEC);
            streamCodec = ProcessingRecipe.streamCodec(factory, DismantleSolderingRecipeParams.STREAM_CODEC);
        }

        @Override
        public MapCodec<DismantleSolderingRecipe> codec() {
            return codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, DismantleSolderingRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
