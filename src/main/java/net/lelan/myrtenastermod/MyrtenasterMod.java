package net.lelan.myrtenastermod;

import com.mojang.logging.LogUtils;
import net.lelan.myrtenastermod.block.ModBlocks;
import net.lelan.myrtenastermod.effect.ModEffects;
import net.lelan.myrtenastermod.item.ModCreativeModeTabs;
import net.lelan.myrtenastermod.item.ModItems;
import net.lelan.myrtenastermod.networking.ModMessages;
import net.lelan.myrtenastermod.particle.ModParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match the entry in the META-INF/mods.toml file
@Mod(MyrtenasterMod.MOD_ID)
public class MyrtenasterMod {
    public static final String MOD_ID = "myrtenastermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MyrtenasterMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModParticles.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModMessages.register();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabs.MYRTENASTER_TAB) {
            //Myrtenaster
            event.accept(ModItems.MYRTENASTER);

            //Items
            event.accept(ModItems.FIRE_ESSENCE);
            event.accept(ModItems.EARTH_ESSENCE);
            event.accept(ModItems.AIR_ESSENCE);
            event.accept(ModItems.ENERGY_CELL);
            event.accept(ModItems.WATER_DROPLET);

            //Blocks
            event.accept(ModBlocks.FIRE_ORE);
            event.accept(ModBlocks.ENERGY_ORE);
            event.accept(ModBlocks.DEEPSLATE_ENERGY_ORE);
            event.accept(ModBlocks.EARTH_BLOCK);
            event.accept(ModBlocks.AIR_FLOWER);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
