package com.sollyw.canopytree;

import com.chocohead.mm.api.ClassTinkerers;
import com.sollyw.canopytree.registry.CanopyTreeBlocks;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class CanopyTreeEarlyRiser implements Runnable{
    @Override
    public void run() {
        final MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        final String boats = remapper.mapClassName("intermediary", "net.minecraft.class_1690$class_1692");
        final String block = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_2248") + ';';

        // Adds canopy boats, because the vanilla boat code is an enum clusterfuck.
        ClassTinkerers.enumBuilder(boats,block, "Ljava.lang.String;").addEnum("CANOPY", () -> new Object[] {CanopyTreeBlocks.CANOPY_PLANKS, "canopy"}).build();
    }
}
