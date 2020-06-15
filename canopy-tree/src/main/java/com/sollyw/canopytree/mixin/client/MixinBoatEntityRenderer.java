package com.sollyw.canopytree.mixin.client;

import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;

// Adds canopy boats to the hardcoded texture array in BoatEntityRenderer.
@Mixin(BoatEntityRenderer.class)
public abstract class MixinBoatEntityRenderer {
    @SuppressWarnings("CanBeFinal")
    @Shadow
    @Final
    @Mutable
    private static Identifier[] TEXTURES;

    static {
        //noinspection ConstantConditions
        TEXTURES = Arrays.copyOf(TEXTURES, TEXTURES.length + 1);
        TEXTURES[TEXTURES.length - 1] = new Identifier("canopy_tree:textures/entity/boat/canopy.png");
    }
}
