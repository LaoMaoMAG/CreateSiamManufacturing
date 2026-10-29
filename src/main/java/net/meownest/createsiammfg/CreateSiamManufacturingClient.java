package net.meownest.createsiammfg;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import net.meownest.createsiammfg.client.CSMPartialModels;
import net.meownest.createsiammfg.client.renderer.entity.SolderSuckerPushEntityRenderer;
import net.meownest.createsiammfg.registry.CSMEntityTypes;

@Mod(value = CreateSiamManufacturing.MOD_ID, dist = Dist.CLIENT)
public class CreateSiamManufacturingClient {

    public CreateSiamManufacturingClient(IEventBus modEventBus) {
        CSMPartialModels.init();
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::registerRenderers);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CSMEntityTypes.SOLDER_SUCKER_PUSH.get(), SolderSuckerPushEntityRenderer::new);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
    }
}