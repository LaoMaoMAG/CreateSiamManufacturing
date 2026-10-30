package net.meownest.createsiammfg.content.item.solder_sucker;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import net.meownest.createsiammfg.content.entity.SolderSuckerPushEntity;
import net.meownest.createsiammfg.registry.CSMDataComponents;

/**
 * 吸锡器物品类
 */
public class SolderSuckerItem extends Item {
    /**
     * 最大使用时间
     */
    public static final int MAX_USE_TICKS = 7300;

    /**
     * 蓄力时间
     */
    public static final int CHARGE_TICKS = 20;

    /**
     * 发射概率
     */
    public static final float FIRE_CHANCE = 0.05f;

    public SolderSuckerItem(Properties properties) {
        super(properties.durability(128));
    }

    /**
     * 是否准备就绪
     *
     * @param stack 吸锡器物品栈
     * @return 是否准备就绪
     */
    public static boolean isReady(ItemStack stack) {
        return stack.getOrDefault(CSMDataComponents.SOLDER_SUCKER_READY, false);
    }

    /**
     * 设置准备状态
     *
     * @param stack 吸锡器物品栈
     * @param ready 是否准备就绪
     */
    public static void setReady(ItemStack stack, boolean ready) {
        if (ready) stack.set(CSMDataComponents.SOLDER_SUCKER_READY, true);
        else stack.remove(CSMDataComponents.SOLDER_SUCKER_READY);
    }

    /**
     * 是否已发射
     *
     * @param stack 吸锡器物品栈
     * @return 是否已发射
     */
    public static boolean isFire(ItemStack stack) {
        return stack.getOrDefault(CSMDataComponents.SOLDER_SUCKER_FIRE, false);
    }

    /**
     * 设置发射状态
     *
     * @param stack 吸锡器物品栈
     * @param fire  是否已发射
     */
    public static void setFire(ItemStack stack, boolean fire) {
        if (fire) {
            stack.set(CSMDataComponents.SOLDER_SUCKER_FIRE, true);
            stack.remove(CSMDataComponents.SOLDER_SUCKER_READY);
        } else stack.remove(CSMDataComponents.SOLDER_SUCKER_FIRE);
    }

    /**
     * 消耗耐久
     *
     * @param stack  物品栈
     * @param player 玩家
     * @param hand   手
     * @param damage 伤害值
     */
    private void damage(ItemStack stack, Player player, InteractionHand hand, int damage) {
        EquipmentSlot slot = hand == InteractionHand.MAIN_HAND
                ? EquipmentSlot.MAINHAND
                : EquipmentSlot.OFFHAND;
        stack.hurtAndBreak(damage, player, slot);
    }

    /**
     * 主动发射
     *
     * @param level  环境
     * @param player 玩家
     * @param usedHand 使用的手
     */
    private void activeFire(Level level, Player player, InteractionHand usedHand){
        ItemStack stack = player.getItemInHand(usedHand);
        setFire(stack, true);
        SolderSuckerPushEntity.shoot(level, player, 3.0F, 0.0F);
        damage(stack, player, usedHand, 3);
    }

    /**
     * 被动发射
     */
    @SuppressWarnings("unused")
    private void passiveFire(){
        /* TODO: 等待实现 */
    }

    public void readyUse(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        RandomSource random = level.random;

        if (level.isClientSide) return;

        // 主动瞄准发射
        if (player.isShiftKeyDown()) {
            activeFire(level, player, usedHand);
            return;
        }

        // 概率被动发射
        if (random.nextFloat() < FIRE_CHANCE) {
            activeFire(level, player, usedHand);
            return;
        }

        // 正常使用
        setReady(stack, false);
        damage(stack, player, usedHand, 1);
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        // 已发射 事件
        if (isFire(stack)) return InteractionResultHolder.fail(stack);

        // 已就绪 事件
        if (isReady(stack)) {
            readyUse(level, player, usedHand);
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
        if (chargeTicks >= CHARGE_TICKS && !isReady(stack)) setReady(stack, true);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack.getItem() != newStack.getItem();
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return MAX_USE_TICKS;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW;
    }
}