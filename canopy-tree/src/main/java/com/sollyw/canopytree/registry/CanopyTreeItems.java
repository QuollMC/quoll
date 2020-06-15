package com.sollyw.canopytree.registry;

import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CanopyTreeItems {
    public static final Item CANOPY_PLANKS = new BlockItem(CanopyTreeBlocks.CANOPY_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CANOPY_SAPLING = new BlockItem(CanopyTreeBlocks.CANOPY_SAPLING, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item CANOPY_LOG = new BlockItem(CanopyTreeBlocks.CANOPY_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item STRIPPED_CANOPY_LOG = new BlockItem(CanopyTreeBlocks.STRIPPED_CANOPY_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item STRIPPED_CANOPY_WOOD = new BlockItem(CanopyTreeBlocks.STRIPPED_CANOPY_WOOD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CANOPY_WOOD = new BlockItem(CanopyTreeBlocks.CANOPY_WOOD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CANOPY_LEAVES = new BlockItem(CanopyTreeBlocks.CANOPY_LEAVES, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item CANOPY_SLAB = new BlockItem(CanopyTreeBlocks.CANOPY_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CANOPY_PRESSURE_PLATE = new BlockItem(CanopyTreeBlocks.CANOPY_PRESSURE_PLATE, new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item CANOPY_FENCE = new BlockItem(CanopyTreeBlocks.CANOPY_FENCE, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item CANOPY_TRAPDOOR = new BlockItem(CanopyTreeBlocks.CANOPY_TRAPDOOR, new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item CANOPY_FENCE_GATE = new BlockItem(CanopyTreeBlocks.CANOPY_FENCE_GATE, new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item CANOPY_BUTTON = new BlockItem(CanopyTreeBlocks.CANOPY_BUTTON, new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item CANOPY_STAIRS = new BlockItem(CanopyTreeBlocks.CANOPY_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CANOPY_DOOR = new TallBlockItem(CanopyTreeBlocks.CANOPY_DOOR, new Item.Settings().group(ItemGroup.REDSTONE));
    public static final Item CANOPY_SIGN = new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), CanopyTreeBlocks.CANOPY_SIGN, CanopyTreeBlocks.CANOPY_WALL_SIGN);
    public static final Item CANOPY_BOAT = new BoatItem(BoatEntity.Type.getType("canopy"), new Item.Settings().maxCount(1).group(ItemGroup.TRANSPORTATION));

    public static void register() {
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_PLANKS), CANOPY_PLANKS);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_SAPLING), CANOPY_SAPLING);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_LOG), CANOPY_LOG);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.STRIPPED_CANOPY_LOG), STRIPPED_CANOPY_LOG);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.STRIPPED_CANOPY_WOOD), STRIPPED_CANOPY_WOOD);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_WOOD), CANOPY_WOOD);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_LEAVES), CANOPY_LEAVES);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_SLAB), CANOPY_SLAB);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_PRESSURE_PLATE), CANOPY_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_FENCE), CANOPY_FENCE);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_TRAPDOOR), CANOPY_TRAPDOOR);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_FENCE_GATE), CANOPY_FENCE_GATE);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_BUTTON), CANOPY_BUTTON);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_STAIRS), CANOPY_STAIRS);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_DOOR), CANOPY_DOOR);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(CanopyTreeBlocks.CANOPY_SIGN), CANOPY_SIGN);
        Registry.register(Registry.ITEM, new Identifier("canopy_tree", "canopy_boat"), CANOPY_BOAT);
    }
}
