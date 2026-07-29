package com.allium.batmancapes.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class ModCreativeTabsFabric {

    public static void register() {

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            ModItems.getAllCapes().values().forEach(entries::accept);
        });
    }
}