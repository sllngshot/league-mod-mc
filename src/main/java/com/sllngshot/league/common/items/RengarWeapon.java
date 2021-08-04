package com.sllngshot.league.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RengarWeapon extends Item {

    public RengarWeapon(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        // Checks for player not on ground or rengar item not in main hand

        //Add rengar jumping code here

        Vec3 lookAngle = player.getLookAngle();
        String lookAngleStr = "Look angle: " + Double.toString(lookAngle.x) + ", "
                + Double.toString(lookAngle.y) + ", "
                + Double.toString(lookAngle.z);


        Vec3 currentPos = player.getPacketCoordinates();
        String currentPosStr = "Current Coords: " + Double.toString(currentPos.x) + ", "
                + Double.toString(currentPos.y) + ", "
                + Double.toString(currentPos.z);

        //RayCasting.getTargetedEntity(player.getPacketCoordinates(), player.getLookAngle(), level.getEntities());

        System.out.println(lookAngleStr);
        System.out.println(currentPosStr);

        return InteractionResultHolder.pass(player.getMainHandItem());
    }

}
