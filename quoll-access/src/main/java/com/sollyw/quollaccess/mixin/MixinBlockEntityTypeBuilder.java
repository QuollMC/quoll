package com.sollyw.quollaccess.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

// Makes the blocks set mutable.
@Mixin(BlockEntityType.Builder.class)
public abstract class MixinBlockEntityTypeBuilder {
    //@Shadow
    @Final
    @Mutable
    private Set<Block> blocks;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void makeBlocksMutable(CallbackInfo info) {
        blocks = new HashSet<>(blocks);
    }
}


