package com.theclod;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class TheClodBlockItemIds {

    public static final BlockItemId BOUNCY_CASTLE_BLOCK = create("bouncy_castle_block");
    public static final BlockItemId BALL_PIT_BLOCK = create("ball_pit_block");

    public static final BlockItemId BOUNCY_CASTLE_WALL = create("bouncy_castle_wall");
    public static final BlockItemId BOUNCY_CASTLE_NETTING = create("bouncy_castle_netting");

    public static final BlockItemId BOUNCY_CASTLE_STAIR = create("bouncy_castle_stair");

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
