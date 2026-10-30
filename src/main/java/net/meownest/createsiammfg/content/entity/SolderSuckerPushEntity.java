package net.meownest.createsiammfg.content.entity;

import org.jetbrains.annotations.Contract;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.meownest.createsiammfg.registry.CSMEntityTypes;
import net.meownest.createsiammfg.registry.CSMItems;

/**
 * 吸锡器推杆实体
 */
public class SolderSuckerPushEntity extends AbstractArrow {
    private static final float DEFAULT_SIZE = 0.3125F;

    private final ItemStack itemStack;

    @Contract(" -> new")
    private static ItemStack getDefaultItem() {
        return new ItemStack(CSMItems.SOLDER_SUCKER_PUSH.asItem());
    }

    public SolderSuckerPushEntity(EntityType<SolderSuckerPushEntity> entityType, Level level) {
        super(entityType, level);
        itemStack = getDefaultItem();
    }

    @SuppressWarnings("unused")
    public SolderSuckerPushEntity(Level level, LivingEntity owner, ItemStack pickupStack, ItemStack weapon) {
        super(CSMEntityTypes.SOLDER_SUCKER_PUSH.get(), owner, level, pickupStack, weapon);
        itemStack = getDefaultItem();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(CSMItems.SOLDER_SUCKER_PUSH.get());
    }

    public static void build(EntityType.Builder<SolderSuckerPushEntity> builder) {
        builder.sized(DEFAULT_SIZE, DEFAULT_SIZE).eyeHeight(0);
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public static void shoot(Level level, LivingEntity shooter, float velocity, float inaccuracy) {
        if (level.isClientSide) return;
        SolderSuckerPushEntity projectile = new SolderSuckerPushEntity(CSMEntityTypes.SOLDER_SUCKER_PUSH.get(), level);
        projectile.setOwner(shooter);
        projectile.setPos(shooter.getX(), shooter.getEyeY() - 0.1D, shooter.getZ());
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, velocity, inaccuracy);
        level.addFreshEntity(projectile);
    }
}
