package com.sylvesternotcute.notcutesign;

import com.sylvesternotcute.notcutesign.client.ClientHandler;
import com.sylvesternotcute.notcutesign.client.renderer.FennecRenderer;
import com.sylvesternotcute.notcutesign.entity.custom.FennecFoxEntity;
import com.sylvesternotcute.notcutesign.init.InitBlocks;
import com.sylvesternotcute.notcutesign.init.InitEntities;
import com.sylvesternotcute.notcutesign.init.InitItem;
import com.sylvesternotcute.notcutesign.items.custom.ModSpawnEgg;
import net.minecraft.entity.EntityType;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(MainMod.MOD_ID)
@Mod.EventBusSubscriber(modid = MainMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "notcutedragofox";

    public MainMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::onAttributeCreate);


        InitItem.ITEMS.register(modEventBus);
        InitBlocks.BLOCKS.register(modEventBus);
        InitEntities.REGISTER.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {


    }

    private void onAttributeCreate(EntityAttributeCreationEvent event)
    {
        event.put(InitEntities.FENNEC_FOX.get(), FennecFoxEntity.setCustomAttributes().build());
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FENNEC_FOX.get(), FennecRenderer::new);
        ClientHandler.setup();
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEgg.initUnaddedEggs();
    }


}
