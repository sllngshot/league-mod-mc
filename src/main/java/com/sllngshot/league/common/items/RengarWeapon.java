package com.sllngshot.league.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.sllngshot.league.core.util.RayCasting;

public class RengarWeapon extends Item {

    public RengarWeapon(Properties properties) {
        super(properties);
    }

    public String printVector(Vec3 lookAngle) {
        String vectorString = "Vector has state: " + Double.toString(lookAngle.x) + ", "
                + Double.toString(lookAngle.y) + ", "
                + Double.toString(lookAngle.z);
        return vectorString;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        // Checks for player not on ground or rengar item not in main hand

        //Add rengar jumping code here

        // searchRadius vector defines x,y,z offsets that create a rectangular prism around the player's location (probably change this to an AABB)
        Vec3 searchRadius = new Vec3(20, 20, 20);

        // samplingRate is the number of samples per unit unit distance along the player's looking direction vector
        double samplingRate = 10;

        // Currently the simple name of the entity that is found in the player's line of sight.
        // rayCast finds the nearest Entity instance, so its position can also be easily returned as a Vec3 after testing.
        System.out.println(RayCasting.rayCast(level, player, searchRadius, samplingRate));

        return InteractionResultHolder.pass(player.getMainHandItem());
    }

}
