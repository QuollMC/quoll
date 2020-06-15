package com.sollyw.canopytree.registry;

import com.sollyw.quollaccess.mixin.AxeItemAccessor;

public class CanopyTreeStrippableBlocks {
    public static void register() {
        AxeItemAccessor.getStrippedBlocks().put(CanopyTreeBlocks.CANOPY_LOG, CanopyTreeBlocks.STRIPPED_CANOPY_LOG);
        AxeItemAccessor.getStrippedBlocks().put(CanopyTreeBlocks.CANOPY_WOOD, CanopyTreeBlocks.STRIPPED_CANOPY_WOOD);
    }
}
