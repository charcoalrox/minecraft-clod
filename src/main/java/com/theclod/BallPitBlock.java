package com.theclod;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class BallPitBlock extends Block {
    public BallPitBlock(Properties properties) {
        super(properties);
    }

    // Makes entities pass right through the physical hitbox
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty(); 
    }

    // Applies the movement drag/resistance when entities are inside
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        entity.makeStuckInBlock(state, new net.minecraft.world.phys.Vec3(0.5D, 3, 0.5D));
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
    }
}