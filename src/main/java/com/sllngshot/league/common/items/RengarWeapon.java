package com.sllngshot.league.common.items;

import com.sllngshot.league.core.init.ItemInit;
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
        if (!player.isOnGround()
                || player.getMainHandItem() != ItemInit.RENGAR_WEAPON.get().getDefaultInstance()) {
            return InteractionResultHolder.fail(player.getMainHandItem());
        }

        //Add rengar jumping code here
        player.moveTo(new Vec3(player.getX(), player.getY() + 5, player.getZ()));
        return InteractionResultHolder.pass(player.getMainHandItem());
    }

}
