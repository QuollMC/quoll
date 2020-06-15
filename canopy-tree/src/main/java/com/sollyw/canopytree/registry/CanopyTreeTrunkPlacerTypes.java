package com.sollyw.canopytree.registry;

import com.sollyw.canopytree.world.gen.trunk.CanopyTrunkPlacer;
import com.sollyw.quollaccess.mixin.TrunkPlacerTypeAccessor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class CanopyTreeTrunkPlacerTypes {
    public static final TrunkPlacerType<CanopyTrunkPlacer> CANOPY_TRUNK_PLACER = TrunkPlacerTypeAccessor.callConstructor(CanopyTrunkPlacer.CODEC);

    public static void register() {
        Registry.register(Registry.TRUNK_PLACER_TYPE, new Identifier("canopy_tree", "canopy_trunk_placer"), CANOPY_TRUNK_PLACER);
    }
}
