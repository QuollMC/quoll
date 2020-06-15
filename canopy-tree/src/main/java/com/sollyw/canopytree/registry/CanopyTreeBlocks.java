package com.sollyw.canopytree.registry;

import com.sollyw.canopytree.block.sapling.CanopySaplingGenerator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CanopyTreeBlocks {
    public static final Block CANOPY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_SAPLING = new SaplingBlock(new CanopySaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)) {};
    public static final Block CANOPY_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_CANOPY_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_CANOPY_WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static final Block CANOPY_SIGN = new SignBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), CanopyTreeSignTypes.CANOPY);
    public static final Block CANOPY_WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(CANOPY_SIGN), CanopyTreeSignTypes.CANOPY);
    public static final Block CANOPY_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)) {};
    public static final Block CANOPY_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()) {};
    public static final Block CANOPY_STAIRS = new StairsBlock(CANOPY_PLANKS.getDefaultState(), Block.Settings.copy(CANOPY_PLANKS)) {};
    public static final Block POTTED_CANOPY_SAPLING = new FlowerPotBlock(CANOPY_SAPLING, FabricBlockSettings.of(Material.SUPPORTED).breakInstantly().nonOpaque());
    public static final Block CANOPY_BUTTON = new WoodButtonBlock(FabricBlockSettings.of(Material.SUPPORTED).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)) {};
    public static final Block CANOPY_SLAB = new SlabBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_FENCE = new FenceBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CANOPY_DOOR = new DoorBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()) {};

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_planks"), CANOPY_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_sapling"), CANOPY_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_log"), CANOPY_LOG);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "stripped_canopy_log"), STRIPPED_CANOPY_LOG);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_wood"), CANOPY_WOOD);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "stripped_canopy_wood"), STRIPPED_CANOPY_WOOD);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_leaves"), CANOPY_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_sign"), CANOPY_SIGN);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_wall_sign"), CANOPY_WALL_SIGN);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_pressure_plate"), CANOPY_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_trapdoor"), CANOPY_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_stairs"), CANOPY_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "potted_canopy_sapling"), POTTED_CANOPY_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_button"), CANOPY_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_slab"), CANOPY_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_fence_gate"), CANOPY_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_fence"), CANOPY_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("canopy_tree", "canopy_door"), CANOPY_DOOR);
    }

    @Environment(EnvType.CLIENT)
    public static void registerClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CANOPY_SAPLING, RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 6396257, CanopyTreeBlocks.CANOPY_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 6396257, CanopyTreeItems.CANOPY_LEAVES);
    }
}
