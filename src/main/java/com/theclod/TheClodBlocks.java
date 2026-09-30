package com.theclod;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TheClodBlocks {
// Overload for blocks w/o items (takes a ResourceKey<Block>)
    private static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block behavior properties with the resource key
        BlockBehaviour.Properties modifiedProperties = properties.setId(key);
        Block block = blockFactory.apply(modifiedProperties);
        
        // Register the block into the built-in block registry
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    // Overload for blocks w/ items (takes a BlockItemId)
    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Calls the resource key overload internally
        Block block = register(id.block(), blockFactory, properties);

        // Create and register the block item instance
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    // Generating new blocks
    public static final Block BOUNCY_CASTLE_BLOCK = register(
        TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK,
        Block::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .destroyTime(1)
            .bounceRestitution(1)
            .ignitedByLava()
    );

    public static final Block BALL_PIT_BLOCK = register(
        TheClodBlockItemIds.BALL_PIT_BLOCK,
        BallPitBlock::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.NETHERRACK)
            .destroyTime(1)
            .noCollision()
            .dynamicShape()
    );

    public static final Block BOUNCY_CASTLE_WALL = register(
        TheClodBlockItemIds.BOUNCY_CASTLE_WALL,
        WallBlock::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .destroyTime(1)
            .bounceRestitution(1)
            .ignitedByLava()
    );

    public static final Block BOUNCY_CASTLE_NETTING = register(
        TheClodBlockItemIds.BOUNCY_CASTLE_NETTING,
        WallBlock::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .destroyTime(1)
            .ignitedByLava()
    );

    public static final Block BOUNCY_CASTLE_STAIR = register(
            TheClodBlockItemIds.BOUNCY_CASTLE_STAIR,
            properties -> new StairBlock(BOUNCY_CASTLE_BLOCK.defaultBlockState(), properties),
            BlockBehaviour.Properties.of()
                .sound(SoundType.WOOL)
                .destroyTime(1)
                .bounceRestitution(1)
                .ignitedByLava()
        );

    // Add blocks to creative tab
	public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BALL_PIT_BLOCK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_NETTING.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR.asItem()));
    }


}
