package com.sollyw.quollaccess.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SignType.class)
public interface SignTypeAccessor {
    @SuppressWarnings("UnusedReturnValue")
    @Invoker
    static SignType callRegister(SignType type) {
        throw new AssertionError();
    }
}
