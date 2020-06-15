package com.sollyw.canopytree.world.gen.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sollyw.canopytree.registry.CanopyTreeFoliagePlacerTypes;
import com.sollyw.quollmath.shape.NaturalCircle;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

/**
 * Generates a clump of canopy tree foliage. While it is rewritten from scratch, it aims to produce the same results as the original generator.
 */
public class CanopyFoliagePlacer extends FoliagePlacer {
    public static final Codec<CanopyFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> method_28846(instance).apply(instance, CanopyFoliagePlacer::new));

    public CanopyFoliagePlacer(int radius, int randomRadius, int offset, int randomOffset) {
        super(radius, randomRadius, offset, randomOffset);
    }

    @Override
    public FoliagePlacerType<?> method_28843() {
        return CanopyTreeFoliagePlacerTypes.CANOPY_FOLIAGE_PLACER;
    }

    // Places three square layers of foliage. The bottom one is radius - 1, the middle one is radius, and the top one is radius - 2.
    @Override
    public void generate(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int i, BlockBox blockBox) {
        this.generate(world, random, config, treeNode.getCenter(), radius - 1 + treeNode.getFoliageRadius(), leaves, -1, treeNode.isGiantTrunk(), blockBox);
        this.generate(world, random, config, treeNode.getCenter(), radius + treeNode.getFoliageRadius(), leaves, 0, treeNode.isGiantTrunk(), blockBox);
        this.generate(world, random, config, treeNode.getCenter(), radius - 2 + treeNode.getFoliageRadius(), leaves, 1, treeNode.isGiantTrunk(), blockBox);
    }

    @Override
    public int getHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    //Returns true if the position is outside a circle. Used by the tree generator to cut circles from the squares generated above.
    @Override
    public boolean isInvalidForLeaves(Random random, int baseHeight, int dx, int dy, int dz, boolean bl) {
        //noinspection SuspiciousNameCombination
        return !NaturalCircle.isWithinRadius(baseHeight, dy, dz);
    }
}
