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

    // Helper function to generate all colors for all blocks of each type much cleaner
    private static Block bouncyCastle(BlockItemId id) {
        return register(
            id,
            Block::new,
            BlockBehaviour.Properties.of()
                .sound(SoundType.WOOL)
                .destroyTime(1)
                .bounceRestitution(1)
                .ignitedByLava()
        );
    }

    private static Block bouncyCastleWall(BlockItemId id) {
        return register(
            id,
            WallBlock::new,
            BlockBehaviour.Properties.of()
                .sound(SoundType.WOOL)
                .destroyTime(1)
                .bounceRestitution(1)
                .ignitedByLava()
        );
    }

    private static Block bouncyCastleStair(BlockItemId id, Block baseBlock) {
        return register(
            id,
            properties -> new StairBlock(baseBlock.defaultBlockState(), properties),
            BlockBehaviour.Properties.of()
                .sound(SoundType.WOOL)
                .destroyTime(1)
                .bounceRestitution(1)
                .ignitedByLava()
        );
    }

    // All bouncy castle colors
    public static final Block BOUNCY_CASTLE_BLOCK_BLACK =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_BLACK);
    public static final Block BOUNCY_CASTLE_BLOCK_BLUE =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_BLUE);
    public static final Block BOUNCY_CASTLE_BLOCK_BROWN =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_BROWN);
    public static final Block BOUNCY_CASTLE_BLOCK_CYAN =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_CYAN);
    public static final Block BOUNCY_CASTLE_BLOCK_DARK_GRAY =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_DARK_GRAY);
    public static final Block BOUNCY_CASTLE_BLOCK_GRAY =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_GRAY);
    public static final Block BOUNCY_CASTLE_BLOCK_GREEN =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_GREEN);
    public static final Block BOUNCY_CASTLE_BLOCK_LIGHT_BLUE =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_LIGHT_BLUE);
    public static final Block BOUNCY_CASTLE_BLOCK_LIME =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_LIME);
    public static final Block BOUNCY_CASTLE_BLOCK_MAGENTA =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_MAGENTA);
    public static final Block BOUNCY_CASTLE_BLOCK_ORANGE =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_ORANGE);
    public static final Block BOUNCY_CASTLE_BLOCK_PINK =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_PINK);
    public static final Block BOUNCY_CASTLE_BLOCK_PURPLE =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_PURPLE);
    public static final Block BOUNCY_CASTLE_BLOCK_RED =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_RED);
    public static final Block BOUNCY_CASTLE_BLOCK_WHITE =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_WHITE);
    public static final Block BOUNCY_CASTLE_BLOCK_YELLOW =
        bouncyCastle(TheClodBlockItemIds.BOUNCY_CASTLE_BLOCK_YELLOW);

    public static final Block BOUNCY_CASTLE_WALL_BLACK = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_BLACK);
    public static final Block BOUNCY_CASTLE_WALL_BLUE = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_BLUE);
    public static final Block BOUNCY_CASTLE_WALL_BROWN = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_BROWN);
    public static final Block BOUNCY_CASTLE_WALL_CYAN = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_CYAN);
    public static final Block BOUNCY_CASTLE_WALL_DARK_GRAY = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_DARK_GRAY);
    public static final Block BOUNCY_CASTLE_WALL_GRAY = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_GRAY);
    public static final Block BOUNCY_CASTLE_WALL_GREEN = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_GREEN);
    public static final Block BOUNCY_CASTLE_WALL_LIGHT_BLUE = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_LIGHT_BLUE);
    public static final Block BOUNCY_CASTLE_WALL_LIME = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_LIME);
    public static final Block BOUNCY_CASTLE_WALL_MAGENTA = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_MAGENTA);
    public static final Block BOUNCY_CASTLE_WALL_ORANGE = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_ORANGE);
    public static final Block BOUNCY_CASTLE_WALL_PINK = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_PINK);
    public static final Block BOUNCY_CASTLE_WALL_PURPLE = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_PURPLE);
    public static final Block BOUNCY_CASTLE_WALL_RED = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_RED);
    public static final Block BOUNCY_CASTLE_WALL_WHITE = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_WHITE);
    public static final Block BOUNCY_CASTLE_WALL_YELLOW = 
        bouncyCastleWall(TheClodBlockItemIds.BOUNCY_CASTLE_WALL_YELLOW);

    public static Block BOUNCY_CASTLE_STAIR_BLACK = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_BLACK, BOUNCY_CASTLE_BLOCK_BLACK);
    public static Block BOUNCY_CASTLE_STAIR_BLUE = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_BLUE, BOUNCY_CASTLE_BLOCK_BLUE);
    public static Block BOUNCY_CASTLE_STAIR_BROWN = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_BROWN, BOUNCY_CASTLE_BLOCK_BROWN);
    public static Block BOUNCY_CASTLE_STAIR_CYAN = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_CYAN, BOUNCY_CASTLE_BLOCK_CYAN);
    public static Block BOUNCY_CASTLE_STAIR_DARK_GRAY = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_DARK_GRAY, BOUNCY_CASTLE_BLOCK_DARK_GRAY);
    public static Block BOUNCY_CASTLE_STAIR_GRAY = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_GRAY, BOUNCY_CASTLE_BLOCK_GRAY);
    public static Block BOUNCY_CASTLE_STAIR_GREEN = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_GREEN, BOUNCY_CASTLE_BLOCK_GREEN);
    public static Block BOUNCY_CASTLE_STAIR_LIGHT_BLUE = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_LIGHT_BLUE, BOUNCY_CASTLE_BLOCK_LIGHT_BLUE);
    public static Block BOUNCY_CASTLE_STAIR_LIME = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_LIME, BOUNCY_CASTLE_BLOCK_LIME);
    public static Block BOUNCY_CASTLE_STAIR_MAGENTA = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_MAGENTA, BOUNCY_CASTLE_BLOCK_MAGENTA);
    public static Block BOUNCY_CASTLE_STAIR_ORANGE = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_ORANGE, BOUNCY_CASTLE_BLOCK_ORANGE);
    public static Block BOUNCY_CASTLE_STAIR_PINK = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_PINK, BOUNCY_CASTLE_BLOCK_PINK);
    public static Block BOUNCY_CASTLE_STAIR_PURPLE = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_PURPLE, BOUNCY_CASTLE_BLOCK_PURPLE);
    public static Block BOUNCY_CASTLE_STAIR_RED = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_RED, BOUNCY_CASTLE_BLOCK_RED);
    public static Block BOUNCY_CASTLE_STAIR_WHITE = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_WHITE, BOUNCY_CASTLE_BLOCK_WHITE);
    public static Block BOUNCY_CASTLE_STAIR_YELLOW = 
        bouncyCastleStair(TheClodBlockItemIds.BOUNCY_CASTLE_STAIR_YELLOW, BOUNCY_CASTLE_BLOCK_YELLOW);

    public static final Block BALL_PIT_BLOCK = register(
        TheClodBlockItemIds.BALL_PIT_BLOCK,
        BallPitBlock::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.NETHERRACK)
            .destroyTime(1)
            .noCollision()
    );

    public static final Block BOUNCY_CASTLE_NETTING = register(
        TheClodBlockItemIds.BOUNCY_CASTLE_NETTING,
        WallBlock::new,
        BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .destroyTime(1)
            .ignitedByLava()
    );

    // Add blocks to creative tab
	public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_BLACK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_BROWN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_CYAN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_DARK_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_GREEN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_LIGHT_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_LIME.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_MAGENTA.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_ORANGE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_PINK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_PURPLE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_RED.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_WHITE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_BLOCK_YELLOW.asItem()));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_BLACK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_BROWN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_CYAN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_DARK_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_GREEN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_LIGHT_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_LIME.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_MAGENTA.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_ORANGE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_PINK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_PURPLE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_RED.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_WHITE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_WALL_YELLOW.asItem()));
            
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_BLACK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_BROWN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_CYAN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_DARK_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_GRAY.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_GREEN.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_LIGHT_BLUE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_LIME.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_MAGENTA.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_ORANGE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_PINK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_PURPLE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_RED.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_WHITE.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_STAIR_YELLOW.asItem()));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BALL_PIT_BLOCK.asItem()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register((creativeTab) -> creativeTab.accept(TheClodBlocks.BOUNCY_CASTLE_NETTING.asItem()));
    }
}
