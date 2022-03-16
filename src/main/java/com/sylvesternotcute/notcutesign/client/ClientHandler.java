package com.sylvesternotcute.notcutesign.client;


import com.sylvesternotcute.notcutesign.client.renderer.FennecRenderer;
import com.sylvesternotcute.notcutesign.client.renderer.SeatRenderer;
import com.sylvesternotcute.notcutesign.init.InitBlocks;
import com.sylvesternotcute.notcutesign.init.InitEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler
{
    public static void setup()
    {
        registerEntityRenderers();
        registerBlockRenderers();
    }

    private static void registerEntityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.SEAT.get(), SeatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FENNEC_FOX.get(), FennecRenderer::new);
    }

    private static void registerBlockRenderers()
    {
        RenderTypeLookup.setRenderLayer(InitBlocks.NOT_CUTE_SIGN.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(InitBlocks.FIXED_NOT_CUTE_SIGN.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(InitBlocks.BAD_DRAGON_KNOT.get(), RenderType.translucent());
    }


}
