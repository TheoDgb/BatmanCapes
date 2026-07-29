package com.allium.batmancapes.registry;

import com.allium.batmancapes.Constants;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.HashMap;
import java.util.Map;

public class ModEquipmentAssets {

    private static final Map<String, ResourceKey<EquipmentAsset>> CACHE = new HashMap<>();

    public static ResourceKey<EquipmentAsset> get(String variantId) {
        return CACHE.computeIfAbsent(variantId, id ->
                ResourceKey.create(
                        net.minecraft.world.item.equipment.EquipmentAssets.ROOT_ID,
                        Identifier.fromNamespaceAndPath(Constants.MOD_ID, id)
                )
        );
    }
}