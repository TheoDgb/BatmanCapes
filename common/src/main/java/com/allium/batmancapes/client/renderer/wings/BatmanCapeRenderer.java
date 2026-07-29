package com.allium.batmancapes.client.renderer.wings;

import com.allium.batmancapes.client.model.BatmanCapeModel;
import com.allium.batmancapes.item.BatmanCapeItem;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.RenderPassInfo;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class BatmanCapeRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<BatmanCapeItem, @NonNull R> {

    private final String variantId;

    public <I extends BatmanCapeItem> BatmanCapeRenderer(I item) {
        super(item);
        this.variantId = item.getVariantId();
    }

    @Override
    public @NonNull GeoModel<BatmanCapeItem> getGeoModel() {
        return new BatmanCapeModel(variantId);
    }

    @Override
    public boolean firePreRenderEvent(@NonNull RenderPassInfo<@NonNull R> renderPassInfo, @NonNull SubmitNodeCollector renderTasks) {
        if (!BatmanCapeItem.RENDER_IN_ELYTRA_LAYER) {
            return false;
        }
        return super.firePreRenderEvent(renderPassInfo, renderTasks);
    }

    @Override
    public long getInstanceId(@NonNull BatmanCapeItem animatable, RenderData stackAndSlot) {
        assert stackAndSlot != null;
        int id = stackAndSlot.entity().getId() * 13;
        return (long) id * id * id * -(stackAndSlot.slot().ordinal() + 1);
    }

    @Override
    public void captureDefaultRenderState(@NonNull BatmanCapeItem animatable, @Nullable RenderData renderData, @NonNull R renderState, float partialTick) {
        assert renderData != null;
        super.captureDefaultRenderState(animatable, renderData, renderState, partialTick);

        boolean isWalking = renderData.entity().walkAnimation.speed() > 0.05f;
        boolean isSprinting = renderData.entity().isSprinting();

        renderState.addGeckolibData(BatmanCapeItem.IS_WALKING, isWalking);
        renderState.addGeckolibData(BatmanCapeItem.IS_SPRINTING, isSprinting);
    }
}