package com.allium.batmancapes.client.renderer.layer;

import com.allium.batmancapes.item.BatmanCapeItem;
import com.geckolib.renderer.GeoArmorRenderer;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;

import net.minecraft.world.entity.EquipmentSlot;
import org.jspecify.annotations.NonNull;

public class BatmanCapeElytraLayer extends RenderLayer<AvatarRenderState, PlayerModel> {

    public BatmanCapeElytraLayer(RenderLayerParent<AvatarRenderState, PlayerModel> parent) {
        super(parent);
    }

    @Override
    public void submit(
            @NonNull PoseStack poseStack,
            @NonNull SubmitNodeCollector collector,
            int light,
            AvatarRenderState state,
            float limbSwing,
            float limbSwingAmount
    ) {
        if (!(state.chestEquipment.getItem() instanceof BatmanCapeItem)) {
            return;
        }

        BatmanCapeItem.RENDER_IN_ELYTRA_LAYER = true;
        try {
            GeoArmorRenderer.tryRenderGeoArmorPiece(
                    (renderState, slot) -> this.getParentModel(),
                    poseStack,
                    collector,
                    state.chestEquipment,
                    EquipmentSlot.CHEST,
                    light,
                    state
            );
        } finally {
            BatmanCapeItem.RENDER_IN_ELYTRA_LAYER = false;
        }
    }
}