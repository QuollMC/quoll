package com.sollyw.canopytree.registry;

import com.sollyw.canopytree.world.gen.foliage.CanopyFoliagePlacer;
import com.sollyw.canopytree.world.gen.trunk.CanopyTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class CanopyTreeBiomeFeatures {
    public static final BlockState CANOPY_LOG = CanopyTreeBlocks.CANOPY_LOG.getDefaultState();
    public static final BlockState CANOPY_LEAVES = CanopyTreeBlocks.CANOPY_LEAVES.getDefaultState();
    public static final TreeFeatureConfig CANOPY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(CANOPY_LOG),
            new SimpleBlockStateProvider(CANOPY_LEAVES),
            new CanopyFoliagePlacer(4, 0, 0, 0), // Canopy foliage always has a 4-block radius.
            new CanopyTrunkPlacer(20, 4, 4), // Random heights have a different meaning for canopy trunks, see CanopyTrunkPlacer#getHeight for details.
            new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build();
}
