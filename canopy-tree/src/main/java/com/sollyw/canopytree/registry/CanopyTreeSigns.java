package com.sollyw.canopytree.registry;

import com.sollyw.quollaccess.mixin.BlockEntityTypeAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;

import java.util.Set;

public class CanopyTreeSigns {
    public static void register() {
        final Set<Block> signs = ((BlockEntityTypeAccessor) BlockEntityType.SIGN).getBlocks();
        signs.add(CanopyTreeBlocks.CANOPY_SIGN);
        signs.add(CanopyTreeBlocks.CANOPY_WALL_SIGN);
    }
}
