package net.meownest.createsiammfg;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import net.meownest.createsiammfg.registry.CSMPartialModels;

@Mod(value = CreateSiamManufacturing.MOD_ID, dist = Dist.CLIENT)
public class CreateSiamManufacturingClient {
    public CreateSiamManufacturingClient() {
        CSMPartialModels.init();
    }
}
