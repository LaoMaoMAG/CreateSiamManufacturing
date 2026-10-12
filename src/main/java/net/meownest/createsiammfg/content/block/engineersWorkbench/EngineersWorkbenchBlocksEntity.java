package net.meownest.createsiammfg.content.block.engineersWorkbench;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class EngineersWorkbenchBlocksEntity extends BlockEntity {

    private final ItemStackHandler inventory = new ItemStackHandler(1) {

        @Override
        public int getSlotLimit(int slot) {
            return slot == 0 ? 1 : 0;
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return slot == 0 && !stack.isEmpty();
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public EngineersWorkbenchBlocksEntity(
            BlockEntityType<?> type,
            BlockPos pos,
            BlockState state
    ) {
        super(type, pos, state);
    }

    /**
     * 获取台面上的物品
     * @return 物品
     */
    public ItemStack getHeldItem() {
        return inventory.getStackInSlot(0).copy();
    }

    /**
     * 设置台面上的物品
     * @param stack 物品
     */
    public void setHeldItem(ItemStack stack) {
        ItemStack item = stack.isEmpty()
                ? ItemStack.EMPTY
                : stack.copyWithCount(1);

        inventory.setStackInSlot(0, item);
    }

    /**
     * 移除并返回台面上的物品
     * @return 物品
     */
    public ItemStack removeHeldItem() {
        return inventory.extractItem(0, 1, false);
    }

    public IItemHandler getItemHandler() {
        return inventory;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ItemStack stack = inventory.getStackInSlot(0);
        tag.put("HeldItem", stack.isEmpty() ? new CompoundTag() : stack.save(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        ItemStack stack = ItemStack.parseOptional(
                registries,
                tag.getCompound("HeldItem")
        );
        setHeldItem(stack);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(
                    worldPosition,
                    getBlockState(),
                    getBlockState(),
                    3
            );
        }
    }
}