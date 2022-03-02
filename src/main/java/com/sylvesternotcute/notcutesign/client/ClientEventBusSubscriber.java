package com.sylvesternotcute.notcutesign.client;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.init.InitBlocks;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.RenderType;

@Mod.EventBusSubscriber(modid = MainMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onStaticClientSetup(FMLClientSetupEvent event) {
        event.setPhase(EventPriority.HIGHEST);
        RenderTypeLookup.setRenderLayer(InitBlocks.NOT_CUTE_SIGN.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(InitBlocks.FIXED_NOT_CUTE_SIGN.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(InitBlocks.BAD_DRAGON_KNOT.get(), RenderType.translucent());
    }

}
