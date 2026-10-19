package net.meownest.createsiammfg;

import net.meownest.createsiammfg.content.item.SolderSuckerItem;
import net.meownest.createsiammfg.registry.CSMItems;
import net.meownest.createsiammfg.registry.CSMPartialModels;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = CreateSiamManufacturing.MOD_ID, dist = Dist.CLIENT)
public class CreateSiamManufacturingClient {

    public CreateSiamManufacturingClient(IEventBus modEventBus) {
        CSMPartialModels.init();
        modEventBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemProperties.register(
                CSMItems.SOLDER_SUCKER.get(),
                ResourceLocation.fromNamespaceAndPath(CreateSiamManufacturing.MOD_ID, "charge"),
                (stack, level, entity, seed) -> {
                    if (!(stack.getItem() instanceof SolderSuckerItem item)) return 0.0F;
                    if (item.isReady(stack)) return 1.0F;
                    if (entity != null && entity.isUsingItem() && entity.getUseItem() == stack) return 0.5F;
                    return 0.0F;
                }
        ));
    }
}