package com.sylvesternotcute.notcutesign.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sylvesternotcute.notcutesign.entity.SeatEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SeatRenderer extends EntityRenderer<SeatEntity>
{
    public SeatRenderer(EntityRendererManager manager)
    {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity seatEntity)
    {
        return null;
    }

    @Override
    protected void renderNameTag(SeatEntity entity, ITextComponent component, MatrixStack matrixStack, IRenderTypeBuffer buffer, int light) {}
}
