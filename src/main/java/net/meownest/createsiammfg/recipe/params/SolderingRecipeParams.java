package net.meownest.createsiammfg.recipe.params;

import java.util.List;
import java.util.function.Function;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import net.createmod.catnip.codecs.stream.CatnipStreamCodecBuilders;

import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;

/**
 * 焊接配方参数
 */
public class SolderingRecipeParams extends ProcessingRecipeParams {

    /**
     * JSON 编解码器
     */
    public static final MapCodec<SolderingRecipeParams> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    // 原有字段
                    codec(SolderingRecipeParams::new)
                            .forGetter(Function.identity()),

                    // 失败概率
                    Codec.floatRange(0.0F, 1.0F)
                            .optionalFieldOf("failure_chance", 0.0F)
                            .forGetter(SolderingRecipeParams::getFailureChance),

                    // 失败产物
                    ProcessingOutput.CODEC_NEW.listOf()
                            .optionalFieldOf("failure_results", List.of())
                            .forGetter(SolderingRecipeParams::getFailureResults),

                    // 焊接次数
                    Codec.intRange(1, 72000)
                            .optionalFieldOf("soldering_count", 1)
                            .forGetter(SolderingRecipeParams::getSolderingCount)

            ).apply(instance, (params, chance, results, count) -> {
                params.failureChance = chance;
                params.failureResults.addAll(results);
                params.solderingCount = count;
                return params;
            }));

    public static final StreamCodec<
            RegistryFriendlyByteBuf, SolderingRecipeParams
            > STREAM_CODEC = streamCodec(SolderingRecipeParams::new);

    private static final StreamCodec<
            RegistryFriendlyByteBuf, NonNullList<ProcessingOutput>
            > FAILURE_RESULTS_CODEC =
            CatnipStreamCodecBuilders.nonNullList(
                    ProcessingOutput.STREAM_CODEC
            );

    /**
     * 失败概率
     */
    private float failureChance = 0.0F;

    /**
     * 失败产物列表
     */
    private NonNullList<ProcessingOutput> failureResults =
            NonNullList.create();

    /**
     * 焊接次数
     */
    private int solderingCount = 1;

    protected SolderingRecipeParams() {
        super();
    }

    public float getFailureChance() {
        return failureChance;
    }

    public List<ProcessingOutput> getFailureResults() {
        return failureResults;
    }

    public int getSolderingCount() {
        return solderingCount;
    }

    @Override
    protected void encode(RegistryFriendlyByteBuf buffer) {
        super.encode(buffer);

        ByteBufCodecs.FLOAT.encode(buffer, failureChance);
        FAILURE_RESULTS_CODEC.encode(buffer, failureResults);
        ByteBufCodecs.VAR_INT.encode(buffer, solderingCount);
    }

    @Override
    protected void decode(RegistryFriendlyByteBuf buffer) {
        super.decode(buffer);

        failureChance = ByteBufCodecs.FLOAT.decode(buffer);
        failureResults = FAILURE_RESULTS_CODEC.decode(buffer);
        solderingCount = ByteBufCodecs.VAR_INT.decode(buffer);
    }
}