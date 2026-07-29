package com.allium.batmancapes.registry;

import com.allium.batmancapes.Constants;
import com.allium.batmancapes.item.BatmanCapeItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    private static final Map<String, BatmanCapeItem> CAPES = new LinkedHashMap<>();

    public static final BatmanCapeItem BATGIRL_CAPE = registerCape("batgirl_cape");
    public static final BatmanCapeItem BLACK_AND_GRAY_CAPE = registerCape("black_and_gray_cape");
    public static final BatmanCapeItem BLUE_AND_GRAY_CAPE = registerCape("blue_and_gray_cape");
    public static final BatmanCapeItem BTAS_CAPE = registerCape("btas_cape");
    public static final BatmanCapeItem CITY_CAPE = registerCape("city_cape");
    public static final BatmanCapeItem FIRST_APPEARANCE_CAPE = registerCape("first_appearance_cape");
    public static final BatmanCapeItem FLASHPOINT_CAPE = registerCape("flashpoint_cape");
    public static final BatmanCapeItem KNIGHT_CAPE = registerCape("knight_cape");
    public static final BatmanCapeItem PATTINSON_CAPE = registerCape("pattinson_cape");

    private static BatmanCapeItem registerCape(String variantId) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Constants.MOD_ID, variantId));
        BatmanCapeItem item = new BatmanCapeItem(variantId, new Item.Properties().setId(key));

        Registry.register(BuiltInRegistries.ITEM, key, item);
        CAPES.put(variantId, item);

        return item;
    }

    public static Map<String, BatmanCapeItem> getAllCapes() {
        return CAPES;
    }

    public static void initialize() {

    }
}