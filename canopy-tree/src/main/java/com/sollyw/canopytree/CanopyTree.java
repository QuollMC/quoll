package com.sollyw.canopytree;

import com.sollyw.canopytree.registry.*;
import net.fabricmc.api.ModInitializer;

public class CanopyTree implements ModInitializer {
    @Override
    public void onInitialize() {
        CanopyTreeBlocks.register();
        CanopyTreeFoliagePlacerTypes.register();
        CanopyTreeItems.register();
        CanopyTreeSigns.register();
        CanopyTreeSignTypes.register();
        CanopyTreeStrippableBlocks.register();
        CanopyTreeTrunkPlacerTypes.register();

        // Uncomment to have canopy trees generate all over the world. Used to test performance and find generation defects.
        //Registry.BIOME.forEach(biome -> biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(CanopyTreeBiomeFeatures.CANOPY_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1)))));
    }
}