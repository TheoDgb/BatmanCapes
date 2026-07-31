package com.allium.batmancapes.client;

import com.allium.batmancapes.Constants;
import com.allium.batmancapes.client.renderer.layer.BatmanCapeElytraLayer;
import com.allium.batmancapes.client.renderer.wings.BatmanCapeRenderer;
import com.allium.batmancapes.registry.ModItems;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.renderer.GeoArmorRenderer;
import com.google.common.base.Suppliers;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jspecify.annotations.NonNull;

import java.util.function.Supplier;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class BatmanCapesNeoForgeClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        ModItems.getAllCapes().values().forEach(capeItem -> {
            capeItem.geoRenderProvider.setValue(new GeoRenderProvider() {

                private final Supplier<GeoArmorRenderer<?, ?>> renderer =
                        Suppliers.memoize(() -> new BatmanCapeRenderer<>(capeItem));

                @Override
                public GeoArmorRenderer<?, ?> getGeoArmorRenderer(
                        @NonNull ItemStack stack,
                        @NonNull EquipmentSlot slot
                ) {
                    return renderer.get();
                }
            });
        });
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {

        for (PlayerModelType skin : event.getSkins()) {

            AvatarRenderer<AbstractClientPlayer> renderer =
                    event.getPlayerRenderer(skin);

            if (renderer != null) {
                renderer.addLayer(new BatmanCapeElytraLayer(renderer));
            }
        }
    }
}