package com.sollyw.canopytree.mixin;

import com.sollyw.canopytree.registry.CanopyTreeItems;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// BoatEntity#asItem uses a switch. This adds support for the added enum value.
@Mixin(BoatEntity.class)
public abstract class MixinBoatEntity {
    @Inject(method = "asItem", at = @At("INVOKE"), cancellable = true)
    private void checkCanopy(CallbackInfoReturnable<Item> info) {
        //noinspection ConstantConditions
        if (((BoatEntity) ((Object) this)).getBoatType().getName().equals("canopy"))
            info.setReturnValue(CanopyTreeItems.CANOPY_BOAT);
    }
}
