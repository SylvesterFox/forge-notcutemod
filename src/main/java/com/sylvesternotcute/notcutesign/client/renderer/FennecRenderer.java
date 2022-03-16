package com.sylvesternotcute.notcutesign.client.renderer;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.entity.custom.FennecFoxEntity;
import com.sylvesternotcute.notcutesign.entity.models.FennecModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FennecRenderer extends MobRenderer<FennecFoxEntity, FennecModel>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(MainMod.MOD_ID, "textures/entity/texture_fennec_fox.png");

    public FennecRenderer(EntityRendererManager rendererManager)
    {
        super(rendererManager, new FennecModel(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(FennecFoxEntity fennecFoxEntity) {
        return TEXTURE;
    }

}
