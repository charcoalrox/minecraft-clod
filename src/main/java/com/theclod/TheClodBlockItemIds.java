package com.theclod;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class TheClodBlockItemIds {

    // block id's
    // This section represents the sins of my past
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_BLACK = create("bouncy_castle_block_black");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_BLUE = create("bouncy_castle_block_blue");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_BROWN = create("bouncy_castle_block_brown");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_CYAN = create("bouncy_castle_block_cyan");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_DARK_GRAY = create("bouncy_castle_block_dark_gray");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_GRAY = create("bouncy_castle_block_gray");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_GREEN = create("bouncy_castle_block_green");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_LIGHT_BLUE = create("bouncy_castle_block_light_blue");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_LIME = create("bouncy_castle_block_lime");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_MAGENTA = create("bouncy_castle_block_magenta");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_ORANGE = create("bouncy_castle_block_orange");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_PINK = create("bouncy_castle_block_pink");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_PURPLE = create("bouncy_castle_block_purple");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_RED = create("bouncy_castle_block_red");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_WHITE = create("bouncy_castle_block_white");
    public static final BlockItemId BOUNCY_CASTLE_BLOCK_YELLOW = create("bouncy_castle_block_yellow");

    public static final BlockItemId BOUNCY_CASTLE_WALL_BLACK = create("bouncy_castle_wall_black");
    public static final BlockItemId BOUNCY_CASTLE_WALL_BLUE = create("bouncy_castle_wall_blue");
    public static final BlockItemId BOUNCY_CASTLE_WALL_BROWN = create("bouncy_castle_wall_brown");
    public static final BlockItemId BOUNCY_CASTLE_WALL_CYAN = create("bouncy_castle_wall_cyan");
    public static final BlockItemId BOUNCY_CASTLE_WALL_DARK_GRAY = create("bouncy_castle_wall_dark_gray");
    public static final BlockItemId BOUNCY_CASTLE_WALL_GRAY = create("bouncy_castle_wall_gray");
    public static final BlockItemId BOUNCY_CASTLE_WALL_GREEN = create("bouncy_castle_wall_green");
    public static final BlockItemId BOUNCY_CASTLE_WALL_LIGHT_BLUE = create("bouncy_castle_wall_light_blue");
    public static final BlockItemId BOUNCY_CASTLE_WALL_LIME = create("bouncy_castle_wall_lime");
    public static final BlockItemId BOUNCY_CASTLE_WALL_MAGENTA = create("bouncy_castle_wall_magenta");
    public static final BlockItemId BOUNCY_CASTLE_WALL_ORANGE = create("bouncy_castle_wall_orange");
    public static final BlockItemId BOUNCY_CASTLE_WALL_PINK = create("bouncy_castle_wall_pink");
    public static final BlockItemId BOUNCY_CASTLE_WALL_PURPLE = create("bouncy_castle_wall_purple");
    public static final BlockItemId BOUNCY_CASTLE_WALL_RED = create("bouncy_castle_wall_red");
    public static final BlockItemId BOUNCY_CASTLE_WALL_WHITE = create("bouncy_castle_wall_white");
    public static final BlockItemId BOUNCY_CASTLE_WALL_YELLOW = create("bouncy_castle_wall_yellow");

    public static final BlockItemId BOUNCY_CASTLE_STAIR_BLACK = create("bouncy_castle_stair_black");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_BLUE = create("bouncy_castle_stair_blue");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_BROWN = create("bouncy_castle_stair_brown");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_CYAN = create("bouncy_castle_stair_cyan");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_DARK_GRAY = create("bouncy_castle_stair_dark_gray");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_GRAY = create("bouncy_castle_stair_gray");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_GREEN = create("bouncy_castle_stair_green");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_LIGHT_BLUE = create("bouncy_castle_stair_light_blue");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_LIME = create("bouncy_castle_stair_lime");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_MAGENTA = create("bouncy_castle_stair_magenta");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_ORANGE = create("bouncy_castle_stair_orange");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_PINK = create("bouncy_castle_stair_pink");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_PURPLE = create("bouncy_castle_stair_purple");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_RED = create("bouncy_castle_stair_red");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_WHITE = create("bouncy_castle_stair_white");
    public static final BlockItemId BOUNCY_CASTLE_STAIR_YELLOW = create("bouncy_castle_stair_yellow");

    // This section represents my finally finding peace
    public static final BlockItemId BOUNCY_CASTLE_NETTING = create("bouncy_castle_netting");
    public static final BlockItemId BALL_PIT_BLOCK = create("ball_pit_block");

    // Blocks w/o items
    public class ModBlockIds {
        private static ResourceKey<Block> create(String name) {
            Identifier id = TheClod.id(name);
            return ResourceKey.create(Registries.BLOCK, id);
        }
    }

    // Blocks w/ items
    private static BlockItemId create(String name) {
        Identifier id = TheClod.id(name);
        return BlockItemId.create(id, id);
    }
}
