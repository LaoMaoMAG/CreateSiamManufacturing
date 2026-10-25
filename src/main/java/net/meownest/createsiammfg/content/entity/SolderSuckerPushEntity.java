package net.meownest.createsiammfg.content.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * 吸锡器推杆实体
 */
public class SolderSuckerPushEntity extends AbstractArrow {
    private static final float DEFAULT_SIZE = 0.3125F;

    public SolderSuckerPushEntity(EntityType<SolderSuckerPushEntity> entityType, Level level) {
        super(entityType, level);

    }

    @Override
    public ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }

    public static void build(EntityType.Builder<SolderSuckerPushEntity> builder) {
        builder.sized(DEFAULT_SIZE, DEFAULT_SIZE).eyeHeight(0);
    }
}
