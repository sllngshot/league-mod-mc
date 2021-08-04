package com.sllngshot.league.core.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class RayCasting {

    public static ArrayList<Vec3> getTargetedEntity(Vec3 playerPos, Vec3 blockPos, List<Entity> entities) {
        ArrayList<Vec3> positionsToCheck = new ArrayList<Vec3>();
        double distBetween = blockPos.distanceTo(playerPos);

        for (double t = 0; t < 1; t += 1/distBetween) {
            positionsToCheck.add(new Vec3(
                    (1 - t) * playerPos.x + t * blockPos.x,
                    (1 - t) * playerPos.y + t * blockPos.y,
                    (1 - t) * playerPos.z + t * blockPos.z));
        }

        return positionsToCheck;
    }

}