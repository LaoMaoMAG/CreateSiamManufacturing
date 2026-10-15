package net.meownest.createsiammfg.recipe.params;

import java.util.function.Function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;

public class DismantleSolderingRecipeParams extends ProcessingRecipeParams {

    public static final MapCodec<DismantleSolderingRecipeParams> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    // 原有字段
                    codec(DismantleSolderingRecipeParams::new)
                            .forGetter(Function.identity())
            ).apply(instance, (params) -> {
                return params;
            }));

    public static final StreamCodec<RegistryFriendlyByteBuf, DismantleSolderingRecipeParams> STREAM_CODEC =
            streamCodec(DismantleSolderingRecipeParams::new);

    public DismantleSolderingRecipeParams() {
        super();
    }

    @Override
    protected void encode(RegistryFriendlyByteBuf buffer) {
        super.encode(buffer);
    }

    @Override
    protected void decode(RegistryFriendlyByteBuf buffer) {
        super.decode(buffer);

    }
}
