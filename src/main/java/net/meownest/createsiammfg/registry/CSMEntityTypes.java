package net.meownest.createsiammfg.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.EntityBuilder;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.createmod.catnip.lang.Lang;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.jetbrains.annotations.NotNull;

/**
 * CMS 实体注册类
 */
public class CSMEntityTypes {
    private static final CreateRegistrate REGISTRATE = CSMRegistrate.REGISTRATE;

    public static void register() {
    }

    private static <T extends Entity> @NotNull EntityBuilder<T, ?> register(
            String name,
            EntityType.EntityFactory<T> factory,
            boolean immuneToFire,
            NonNullConsumer<EntityType.Builder<T>> propertyBuilder
    ) {
        return REGISTRATE.entity(Lang.asId(name), factory, MobCategory.MISC)
                .defaultLang()
                .properties(builder -> builder.setTrackingRange(4)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                )
                .properties(propertyBuilder)
                .properties(builder -> {
                    if (immuneToFire) {
                        builder.fireImmune();
                    }
                });
    }
}
