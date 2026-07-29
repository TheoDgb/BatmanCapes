package com.allium.batmancapes.client;

import com.allium.batmancapes.client.renderer.wings.BatmanCapeRenderer;
import com.allium.batmancapes.client.renderer.layer.BatmanCapeElytraLayer;
import com.allium.batmancapes.registry.ModItems;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.renderer.GeoArmorRenderer;
import com.google.common.base.Suppliers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityRenderLayerRegistrationCallback;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.function.Supplier;

public class BatmanCapesFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItems.getAllCapes().values().forEach(capeItem -> {
            capeItem.geoRenderProvider.setValue(new GeoRenderProvider() {
                private final Supplier<GeoArmorRenderer<?, ?>> renderer =
                        Suppliers.memoize(() -> new BatmanCapeRenderer<>(capeItem));

                @Override
                public GeoArmorRenderer<?, ?> getGeoArmorRenderer(@NonNull ItemStack itemStack, @NonNull EquipmentSlot equipmentSlot) {
                    return renderer.get();
                }
            });
        });

        LivingEntityRenderLayerRegistrationCallback.EVENT.register(
                (entityType, entityRenderer, registrationHelper, context) -> {
                    if (entityRenderer instanceof AvatarRenderer<?> avatarRenderer) {
                        registrationHelper.register(new BatmanCapeElytraLayer(avatarRenderer));
                    }
                }
        );
    }
}