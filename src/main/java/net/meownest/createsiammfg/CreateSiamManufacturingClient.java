package net.meownest.createsiammfg;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import net.meownest.createsiammfg.registry.CSMPartialModels;

@Mod(value = CreateSiamManufacturing.MOD_ID, dist = Dist.CLIENT)
public class CreateSiamManufacturingClient {

    public CreateSiamManufacturingClient(IEventBus modEventBus) {
        CSMPartialModels.init();
        modEventBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
    }
}