package com.sylvesternotcute.notcutesign.client;


import com.sylvesternotcute.notcutesign.client.renderer.SeatRenderer;
import com.sylvesternotcute.notcutesign.init.InitEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler
{
    public static void setup()
    {
        registerEntityRenderers();
    }

    private static void registerEntityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.SEAT.get(), SeatRenderer::new);
    }
}
