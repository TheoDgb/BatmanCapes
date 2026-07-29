package com.allium.batmancapes.client.model;

import com.allium.batmancapes.Constants;
import com.allium.batmancapes.item.BatmanCapeItem;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class BatmanCapeModel extends GeoModel<BatmanCapeItem> {

    private final String variantId;

    public BatmanCapeModel(String variantId) {
        this.variantId = variantId;
    }

    @Override
    public @NonNull Identifier getModelResource(@NonNull GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, "entity/equipment/wings/batman_cape");
    }

    @Override
    public @NonNull Identifier getTextureResource(@NonNull GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/entity/equipment/wings/" + this.variantId + ".png");
    }

    @Override
    public @NonNull Identifier getAnimationResource(@NonNull BatmanCapeItem animatable) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, "entity/equipment/wings/batman_cape");
    }
}