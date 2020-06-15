package com.sollyw.canopytree.registry;

import com.sollyw.quollaccess.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class CanopyTreeSignTypes {
    public static final SignType CANOPY = new SignType("canopy") {};

    public static void register() {
        SignTypeAccessor.callRegister(CANOPY);
    }
}
