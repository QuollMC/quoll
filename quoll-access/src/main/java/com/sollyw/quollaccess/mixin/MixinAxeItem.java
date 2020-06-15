package com.sollyw.quollaccess.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

// Makes the STRIPPED_BLOCKS map mutable.
@Mixin(AxeItem.class)
public abstract class MixinAxeItem {
    @SuppressWarnings("CanBeFinal")
    @Shadow
    @Final
    @Mutable
    protected static Map<Block, Block> STRIPPED_BLOCKS;

    static {
        //noinspection ConstantConditions
        STRIPPED_BLOCKS = new HashMap<>(STRIPPED_BLOCKS);
    }
}
