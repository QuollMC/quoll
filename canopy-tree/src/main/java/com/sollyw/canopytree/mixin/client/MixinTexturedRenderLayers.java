package com.sollyw.canopytree.mixin.client;

import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// MixinTexturedRenderLayers#getSignTextureId always uses the default namespace. This adds a namespace for canopy signs.
@Mixin(TexturedRenderLayers.class)
public abstract class MixinTexturedRenderLayers {
    @Inject(method = "getSignTextureId", at = @At("INVOKE"), cancellable = true)
    private static void addNamespace(SignType type, CallbackInfoReturnable<SpriteIdentifier> info) {
        if (type.getName().equals("canopy"))
            info.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, new Identifier("canopy_tree:entity/signs/" + type.getName())));
    }
}
