package net.meownest.createsiammfg.registry;

import java.util.function.UnaryOperator;
import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.meownest.createsiammfg.CreateSiamManufacturing;

public class CSMDataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister
            .create(BuiltInRegistries.DATA_COMPONENT_TYPE, CreateSiamManufacturing.MOD_ID);

    /**
     * 吸锡器就绪状态
     */
    public static final DataComponentType<Boolean> SOLDER_SUCKER_READY = CSMDataComponents.register(
            "solder_sucker_ready",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );

    /**
     * 吸锡器发射状态
     */
    public static final DataComponentType<Boolean> SOLDER_SUCKER_FIRE = CSMDataComponents.register(
            "solder_sucker_fire",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );

    public static void register(IEventBus eventBus) {
        COMPONENTS.register(eventBus);
    }

    private static <T> @NotNull DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        DataComponentType<T> type = builder.apply(DataComponentType.builder()).build();
        COMPONENTS.register(name, () -> type);
        return type;
    }
}
