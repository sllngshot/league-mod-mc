package com.sllngshot.league;

import com.sllngshot.league.client.tabs.LeagueTab;
import com.sllngshot.league.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(League.MOD_ID)
public class League {

    // MEMBER VARIABLES
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "league";
    public static final LeagueTab LEAGUE_TAB = new LeagueTab(MOD_ID);

    public League() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        // Registration of deferred registers goes here
        ItemInit.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

}
