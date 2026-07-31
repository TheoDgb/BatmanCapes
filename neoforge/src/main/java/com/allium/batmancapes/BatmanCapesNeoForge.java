package com.allium.batmancapes;

import com.allium.batmancapes.client.BatmanCapesNeoForgeClient;
import com.allium.batmancapes.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class BatmanCapesNeoForge {

    public BatmanCapesNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        // Constants.LOG.info("Hello NeoForge world!");

        CommonClass.init();

        eventBus.addListener(this::registerItems);
    }

    private void registerItems(RegisterEvent event) {
        event.register(Registries.ITEM, helper -> ModItems.initialize());
    }
}