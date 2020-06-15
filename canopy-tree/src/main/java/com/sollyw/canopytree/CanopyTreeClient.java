package com.sollyw.canopytree;

import com.sollyw.canopytree.registry.CanopyTreeBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class CanopyTreeClient implements ClientModInitializer {
    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        CanopyTreeBlocks.registerClient();
    }
}
