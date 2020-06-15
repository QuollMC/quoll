package com.sollyw.canopytree.block.sapling;

import com.sollyw.canopytree.registry.CanopyTreeBiomeFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class CanopySaplingGenerator extends SaplingGenerator {
    public ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Feature.TREE.configure(CanopyTreeBiomeFeatures.CANOPY_TREE_CONFIG);
    }
}