package com.sllngshot.league.core.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class RayCasting {

    public static String rayCast(Level level, Player player, Vec3 searchRadius, double samplingRate) {
        // Get player's current position and viewing angle
        Vec3 currentPos = player.getEyePosition();
        Vec3 lookAngle = player.getLookAngle();

        // Create a new AABB cube of side length 2*searchRadius around the player
        Vec3 startBox = new Vec3(currentPos.x - searchRadius.x, currentPos.y - searchRadius.y, currentPos.z - searchRadius.z);
        Vec3 endBox = new Vec3(currentPos.x + searchRadius.x, currentPos.y + searchRadius.y, currentPos.z + searchRadius.z);
        AABB searchBlocks = new AABB(startBox, endBox);

        // Search for entities in within this AABB (remove the player because we'll never want to jump to the player)
        List<Entity> entitiesFound = level.getEntities(null, searchBlocks);
        entitiesFound.remove(player);

        // Sample along the player's looking direction vector, with the given rate and radius
        // If we hit a block that is NOT air, then we stop sampling, as we cannot jump there anyway.
        double maxSearchRadius = Math.max(searchRadius.x, searchRadius.z);
        ArrayList<Vec3> samples = new ArrayList<>();
        for (double i = 0; i < maxSearchRadius; i += 1/samplingRate) {
            Vec3 sample = lookAngle.multiply(i,i,i).add(currentPos);
            BlockState blockFound = level.getBlockState(new BlockPos(sample));
            if (blockFound.getBlock().getRegistryName().toString().equals("minecraft:air")) {
                samples.add(sample);
            } else {
                break;
            }
        }

        // Look at each sample point in the player's line of sight, checking if there is an entity at this point
        for (Vec3 sample : samples) {
            for (Entity e : entitiesFound) {
                AABB entityHitBox = e.getBoundingBox();
                if (entityHitBox.contains(sample)) {
                    return e.getClass().getSimpleName();
                }
            }
        }
        return "No entity found";
    }
}