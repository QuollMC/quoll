package com.sollyw.canopytree.world.gen.trunk;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sollyw.canopytree.registry.CanopyTreeTrunkPlacerTypes;
import com.sollyw.quollmath.Vec2d;
import com.sollyw.quollmath.shape.Line;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Generates a canopy tree trunk. While it is rewritten from scratch and optimised a bit, it aims to produce the same results as the original generator.
 */
public class CanopyTrunkPlacer extends TrunkPlacer {
    public static final Codec<CanopyTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> method_28904(instance).apply(instance, CanopyTrunkPlacer::new));

    //The angle (pitch) branches stick up at is constant. The cos and sin can be stored here instead of being calculated every time.
    private static final double BRANCH_ANGLE_SIN = Math.sin(Math.toRadians(36)) * 9;
    private static final double BRANCH_ANGLE_COS = Math.cos(Math.toRadians(36)) * 9;

    public CanopyTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    public TrunkPlacerType<?> method_28903() {
        return CanopyTreeTrunkPlacerTypes.CANOPY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig) {
        // Place dirt below the sapling.
        method_27400(world, pos.down());

        // List of positions to place foliage at.
        final List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        // Add foliage at the top of the trunk.
        list.add(new FoliagePlacer.TreeNode(pos.up(trunkHeight), 0, false));

        // Generate the trunk.
        for(int b = 0; b <= trunkHeight; b++) {
            method_27402(world, random, pos.up(b), set, blockBox, treeFeatureConfig);
        }

        // Choose whether the tree will have 3 or 4 branches.
        final int branches = 3 + random.nextInt(2);
        // Random float between 0 and 1, in radians, added to the branch yaw for randomness. Otherwise all trees would have branches pointing in the same direction.
        float offset = random.nextFloat();

        for (int b = 0; b < branches; b++) {
            // Create an angle, in radians, for the branch yaw and convert it to a vector2. Values tend to be well-spaced to avoid overlapping branches while remaining random-looking.
            final Vec2d yv = Vec2d.fromAngle(b * 0.6 * Math.PI + offset);
            // The starting point for the branch. Each branch starts one block above the previous branch, starting from 10 blocks below the top of the trunk.
            final BlockPos s = pos.up(trunkHeight - 10 + b);
            // Calculate the ending point of the branch.
            final BlockPos d = s.add(new Vec3i(yv.x * BRANCH_ANGLE_SIN, BRANCH_ANGLE_COS, yv.y * BRANCH_ANGLE_SIN));
            // Create a line between the two points and draw it into the world.
            for (Vec3i point : Line.get3D(s, d)) {
                method_27402(world, random, new BlockPos(point), set, blockBox, treeFeatureConfig);
            }

            // Add foliage at the end of the branch.
            list.add(new FoliagePlacer.TreeNode(d, 0, false));
        }

        return list;
    }

    // Biases the random height towards shorter trees.
    @Override
    public int getHeight(Random random) {
        int height = this.baseHeight;
        if (random.nextInt(3) == 0) {
            height += random.nextInt(this.firstRandomHeight + 1);

            if (random.nextInt(8) == 0)
                height += random.nextInt(this.secondRandomHeight + 1);
        }
        return height;
    }
}