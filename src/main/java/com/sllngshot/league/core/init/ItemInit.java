package com.sllngshot.league.core.init;

import com.sllngshot.league.League;
import com.sllngshot.league.common.items.RengarWeapon;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    /* Deferred Register for Item registration */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, League.MOD_ID);

    /**
     * Registration of all Items and custom Items
     */
    public static final RegistryObject<Item> RENGAR_WEAPON = ITEMS.register("rengar_weapon",
            () -> new RengarWeapon(new Item.Properties()
                    .setNoRepair()
                    .stacksTo(4)
                    .tab(League.LEAGUE_TAB)));

}
