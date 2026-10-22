package net.meownest.createsiammfg.content.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * 吸锡器物品类
 */
public class SolderSuckerItem extends Item {
    /**
     * 最大使用时间
     */
    public static final int MAX_USE_TICKS = 72000;

    /**
     * 蓄力时间
     */
    public static final int CHARGE_TICKS = 20;

    /**
     * 就绪状态数据键
     */
    private static final String READY_KEY = "SolderSuckerReady";

    /**
     * 发射状态数据键
     */
    private static final String FIRE_KEY = "SolderSuckerFire";

    public SolderSuckerItem(Properties properties) {
        super(properties);
    }

    /**
     * 是否准备就绪
     *
     * @param stack 吸锡器物品栈
     * @return 是否准备就绪
     */
    public static boolean isReady(ItemStack stack) {
        return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(READY_KEY);
    }

    /**
     * 设置准备状态
     *
     * @param stack 吸锡器物品栈
     * @param ready 是否准备就绪
     */
    public static void setReady(ItemStack stack, boolean ready) {
        CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> {
            if (ready) tag.putBoolean(READY_KEY, true);
            else tag.remove(READY_KEY);
        });
    }

    /**
     * 是否已发射
     *
     * @param stack 吸锡器物品栈
     * @return 是否已发射
     */
    public static boolean isFire(ItemStack stack) {
        return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(FIRE_KEY);
    }

    /**
     * 设置发射状态
     *
     * @param stack 吸锡器物品栈
     * @param fire 是否已发射
     */
    public static void setFire(ItemStack stack, boolean fire) {
        CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> {
            if (fire) tag.putBoolean(FIRE_KEY, true);
            else tag.remove(FIRE_KEY);
        });
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return MAX_USE_TICKS;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW;
    }

    /**
     * 准备就绪时执行的使用
     *
     * @param level    环境
     * @param player   玩家
     * @param usedHand 使用的手
     * @param stack    物品栈
     */
    private void performReadyUse(Level level, Player player, InteractionHand usedHand, ItemStack stack) {

    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        // 已就绪 事件
        if (isReady(stack)) {
            if (!level.isClientSide) {
                performReadyUse(level, player, usedHand, stack);
                setReady(stack, false);
            }
            return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
        }

        // 未就绪 事件
        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void onUseTick(Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
        if (level.isClientSide || isReady(stack)) return;
        int chargeTicks = getUseDuration(stack, livingEntity) - remainingUseDuration;
        if (chargeTicks >= CHARGE_TICKS) setReady(stack, true);
    }
}