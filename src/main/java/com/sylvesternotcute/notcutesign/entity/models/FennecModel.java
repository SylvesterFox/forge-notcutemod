package com.sylvesternotcute.notcutesign.entity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sylvesternotcute.notcutesign.entity.custom.FennecFoxEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class FennecModel extends EntityModel<FennecFoxEntity> {
    private final ModelRenderer root;
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer ears;
    private final ModelRenderer left;
    private final ModelRenderer ear_1;
    private final ModelRenderer ear_2;
    private final ModelRenderer ear_2_r1;
    private final ModelRenderer ear_2_r2;
    private final ModelRenderer right;
    private final ModelRenderer ear_3;
    private final ModelRenderer ear_4;
    private final ModelRenderer tail;
    private final ModelRenderer leg_right_0;
    private final ModelRenderer leg_left_1;
    private final ModelRenderer leg_right_2;
    private final ModelRenderer leg_left_3;


    public FennecModel() {
        texWidth = 64;
        texHeight = 64;

        root = new ModelRenderer(this);
        root.setPos(0.0F, 24.0F, 0.3F);


        body = new ModelRenderer(this);
        body.setPos(0.0F, -1.3F, 0.0F);
        root.addChild(body);
        body.texOffs(0, 0).addBox(-3.0F, -10.7F, -6.0F, 6.0F, 6.0F, 11.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -7.0F, -6.0F);
        body.addChild(head);
        head.texOffs(0, 18).addBox(-4.0F, -4.8F, -6.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
        head.texOffs(36, 18).addBox(-2.0F, -0.8F, -9.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

        ears = new ModelRenderer(this);
        ears.setPos(0.0F, 7.0F, 0.0F);
        head.addChild(ears);


        left = new ModelRenderer(this);
        left.setPos(7.1F, -5.8F, -1.6F);
        ears.addChild(left);
        setRotationAngle(left, 0.0F, 0.0F, 0.3491F);


        ear_1 = new ModelRenderer(this);
        ear_1.setPos(-4.7F, -1.0F, -2.1F);
        left.addChild(ear_1);
        setRotationAngle(ear_1, -0.0062F, 0.2353F, -0.0005F);
        ear_1.texOffs(39, 55).addBox(-1.2228F, -9.5578F, 0.9123F, 3.0F, 8.0F, 1.0F, 0.0F, false);
        ear_1.texOffs(58, 52).addBox(-1.2228F, -12.5578F, 0.9123F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        ear_1.texOffs(49, 61).addBox(-1.2228F, -11.5578F, 0.9123F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        ear_1.texOffs(50, 54).addBox(1.7772F, -5.5578F, 0.9123F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        ear_2 = new ModelRenderer(this);
        ear_2.setPos(-6.0F, -1.1F, -1.0F);
        left.addChild(ear_2);
        setRotationAngle(ear_2, -0.0009F, 0.0003F, -0.0198F);
        ear_2.texOffs(41, 52).addBox(-0.29F, -12.3624F, 0.0946F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ear_2_r1 = new ModelRenderer(this);
        ear_2_r1.setPos(3.6F, 6.9F, 10.3F);
        ear_2.addChild(ear_2_r1);
        setRotationAngle(ear_2_r1, 0.0F, 0.0F, 0.0175F);
        ear_2_r1.texOffs(32, 61).addBox(-5.2F, -18.2559F, -10.2F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        ear_2_r2 = new ModelRenderer(this);
        ear_2_r2.setPos(-4.0F, 8.0F, 9.0F);
        ear_2.addChild(ear_2_r2);
        setRotationAngle(ear_2_r2, 0.0F, 0.0F, 0.0175F);
        ear_2_r2.texOffs(56, 55).addBox(1.3738F, -17.5624F, -8.9054F, 3.0F, 8.0F, 1.0F, 0.0F, false);

        right = new ModelRenderer(this);
        right.setPos(4.0F, 0.0F, 7.4F);
        ears.addChild(right);
        setRotationAngle(right, 0.0F, 0.0F, -0.3491F);


        ear_3 = new ModelRenderer(this);
        ear_3.setPos(-3.3F, -11.0F, -9.7F);
        right.addChild(ear_3);
        setRotationAngle(ear_3, 0.0102F, -0.0611F, -0.0163F);
        ear_3.texOffs(56, 55).addBox(-2.7626F, -8.6559F, -0.059F, 3.0F, 8.0F, 1.0F, 0.0F, false);
        ear_3.texOffs(32, 61).addBox(-1.7626F, -10.6559F, -0.059F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        ear_3.texOffs(58, 52).addBox(-0.7626F, -11.6559F, -0.059F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        ear_3.texOffs(33, 54).addBox(-3.7626F, -4.6559F, -0.059F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        ear_4 = new ModelRenderer(this);
        ear_4.setPos(-2.8F, -12.0F, -10.8F);
        right.addChild(ear_4);
        setRotationAngle(ear_4, 0.026F, 0.1396F, -0.0009F);
        ear_4.texOffs(39, 55).addBox(-0.7642F, -7.6578F, 1.0416F, 3.0F, 8.0F, 1.0F, 0.0F, false);
        ear_4.texOffs(49, 61).addBox(-0.7642F, -9.6578F, 1.0416F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        ear_4.texOffs(41, 52).addBox(-0.7642F, -10.6578F, 1.0416F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, -8.0F, 5.0F);
        body.addChild(tail);
        tail.texOffs(35, 0).addBox(-2.0F, -1.3F, 0.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
        tail.texOffs(39, 14).addBox(-1.0F, 7.3F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        leg_right_0 = new ModelRenderer(this);
        leg_right_0.setPos(2.0F, -5.0F, 3.0F);
        body.addChild(leg_right_0);
        leg_right_0.texOffs(0, 31).addBox(-5.0F, 0.25F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg_left_1 = new ModelRenderer(this);
        leg_left_1.setPos(-2.0F, -5.0F, 3.0F);
        body.addChild(leg_left_1);
        leg_left_1.texOffs(0, 31).addBox(3.0F, 0.25F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg_left_3 = new ModelRenderer(this);
        leg_left_3.setPos(2.0F, -5.0F, -4.1F);
        body.addChild(leg_left_3);
        leg_left_3.texOffs(9, 31).addBox(-5.0F, 0.25F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leg_right_2 = new ModelRenderer(this);
        leg_right_2.setPos(5.8F, -5.0F, -4.1F);
        body.addChild(leg_right_2);
        leg_right_2.texOffs(9, 31).addBox(-4.8F, 0.25F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
    }


    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        root.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void setupAnim(FennecFoxEntity entity, final float limbSwing, final float limbSwingAmount,
                          final float ageInTicks, final float netHeadYaw, final float headPitch) {
       this.head.xRot = headPitch * ((float) Math.PI / 180F);
       this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
       this.leg_right_0.xRot = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
       this.leg_right_2.xRot = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
       this.leg_left_1.xRot = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
       this.leg_left_3.xRot = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    }

}
