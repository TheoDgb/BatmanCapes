package com.allium.batmancapes.mixin;

import com.allium.batmancapes.item.BatmanCapeItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.layers.WingsLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WingsLayer.class)
public class WingsLayerMixin {

    @Inject(
            method = "submit*",
            at = @At("HEAD"),
            cancellable = true
    )
    private void batmancapes$cancelVanillaWings(
            PoseStack poseStack,
            SubmitNodeCollector submitNodeCollector,
            int lightCoords,
            HumanoidRenderState state,
            float yRot,
            float xRot,
            CallbackInfo ci
    ) {
        if (state.chestEquipment.getItem() instanceof BatmanCapeItem) {
            ci.cancel();
        }
    }
}