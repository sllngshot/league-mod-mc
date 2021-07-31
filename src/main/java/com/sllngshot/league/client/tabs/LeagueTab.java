package com.sllngshot.league.client.tabs;

import com.sllngshot.league.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LeagueTab extends CreativeModeTab {

    public LeagueTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return ItemInit.RENGAR_WEAPON.get().getDefaultInstance();
    }
}
