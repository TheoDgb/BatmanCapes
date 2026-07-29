package com.allium.batmancapes.item;

import com.allium.batmancapes.registry.ModEquipmentAssets;
import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.constant.DataTickets;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.reflect.TypeToken;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class BatmanCapeItem extends Item implements GeoAnimatable, GeoItem {

    public static final DataTicket<Boolean> IS_WALKING = DataTicket.create("batmancape_is_walking", new TypeToken<>() {});
    public static final DataTicket<Boolean> IS_SPRINTING = DataTicket.create("batmancape_is_sprinting", new TypeToken<>() {});

    public static boolean RENDER_IN_ELYTRA_LAYER = false;

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public final MutableObject<GeoRenderProvider> geoRenderProvider = new MutableObject<>();

    private final String variantId;

    public BatmanCapeItem(String variantId, Properties properties) {
        super(properties
                .durability(432)
                .component(DataComponents.GLIDER, Unit.INSTANCE)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                        .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                        .setAsset(ModEquipmentAssets.get(variantId))
                        .setDamageOnHurt(false)
                        .build())
        );
        this.variantId = variantId;
    }

    public String getVariantId() {
        return this.variantId;
    }

    @Override
    public void registerControllers(final AnimatableManager.@NonNull ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(
                        "cape_controller",
                        5,
                        state -> {
                            var pose = state.getData(DataTickets.ENTITY_POSE);

                            if (pose == Pose.FALL_FLYING) {
                                return state.setAndContinue(
                                        RawAnimation.begin().thenLoop("animation.batman_cape.gliding")
                                );
                            }

                            if (pose == Pose.CROUCHING) {
                                return state.setAndContinue(
                                        RawAnimation.begin().thenLoop("animation.batman_cape.crouching")
                                );
                            }

//                            if (state.getData(IS_SPRINTING) == Boolean.TRUE) {
//                                return state.setAndContinue(
//                                        RawAnimation.begin().thenLoop("animation.batman_cape.sprinting")
//                                );
//                            }

                            if (state.getData(IS_WALKING) == Boolean.TRUE) {
                                boolean isSprinting = state.getData(IS_SPRINTING) == Boolean.TRUE;

                                return state.setAndContinue(
                                        RawAnimation.begin().thenLoop(
                                                isSprinting ? "animation.batman_cape.sprinting" : "animation.batman_cape.walking"
                                        )
                                );
                            }

                            return state.setAndContinue(
                                    RawAnimation.begin().thenLoop("animation.batman_cape.idle")
                            );
                        }
                )
        );
    }

    @Override
    public @NonNull AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(this.geoRenderProvider.get());
    }
}