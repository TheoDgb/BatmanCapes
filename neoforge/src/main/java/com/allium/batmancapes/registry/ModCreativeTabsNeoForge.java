package com.allium.batmancapes.registry;

import com.allium.batmancapes.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ModCreativeTabsNeoForge {

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            ModItems.getAllCapes().values().forEach(event::accept);
        }
    }
}