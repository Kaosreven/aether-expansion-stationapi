package io.github.kaosreven.aetherex.client.entity.renderer.living;

import io.github.kaosreven.aetherex.entity.EntityOrangeMoa;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class RenderOrangeMoa extends LivingEntityRenderer {
    public RenderOrangeMoa(EntityModel modelbase, float f) {
        super(modelbase, f);
    }

    public void renderChicken(EntityOrangeMoa entityorangemoa, double d, double d1, double d2, float f, float f1) {
        super.render(entityorangemoa, d, d1, d2, f, f1);
    }

    protected float getWingRotation(EntityOrangeMoa entityorangemoa, float f) {
        float f1 = entityorangemoa.field_756_e + (entityorangemoa.field_752_b - entityorangemoa.field_756_e) * f;
        float f2 = entityorangemoa.field_757_d + (entityorangemoa.destPos - entityorangemoa.field_757_d) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float getHeadBob(LivingEntity entityliving, float f) {
        return this.getWingRotation((EntityOrangeMoa) entityliving, f);
    }

    public void render(LivingEntity entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderChicken((EntityOrangeMoa) entityliving, d, d1, d2, f, f1);
    }

    public void render(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderChicken((EntityOrangeMoa) entity, d, d1, d2, f, f1);
    }

    protected void scalemoa() {
        GL11.glScalef(1.8F, 1.8F, 1.8F);
    }

    protected void applyScale(LivingEntity entityliving, float f) {
        if (!(entityliving instanceof EntityOrangeMoa) || !((EntityOrangeMoa) entityliving).baby) {
            this.scalemoa();
        }
    }
}
