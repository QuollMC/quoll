package com.sollyw.canopytree.registry;

import com.sollyw.canopytree.world.gen.foliage.CanopyFoliagePlacer;
import com.sollyw.quollaccess.mixin.FoliagePlacerTypeAccessor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CanopyTreeFoliagePlacerTypes {
    public static final FoliagePlacerType<CanopyFoliagePlacer> CANOPY_FOLIAGE_PLACER = FoliagePlacerTypeAccessor.callConstructor(CanopyFoliagePlacer.CODEC);

    public static void register() {
        Registry.register(Registry.FOLIAGE_PLACER_TYPE, new Identifier("canopy_tree", "canopy_foliage_placer"), CANOPY_FOLIAGE_PLACER);
    }
}
