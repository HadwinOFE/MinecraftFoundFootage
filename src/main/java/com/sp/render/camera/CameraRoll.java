package com.sp.render.camera;

import com.sp.SPBRevampedClient;
import com.sp.compat.modmenu.ConfigStuff;
import com.sp.util.MathStuff;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;

public class CameraRoll {
    static float prevYaw;
    static float rotAmount;
    static float spinRoll;

    static float strafeRoll;

    public static float doCameraRoll(PlayerEntity player, float tickDelta){
        if (player != null) {
            float yaw = player.getYaw(tickDelta);
            float lastFrameDuration = MinecraftClient.getInstance().getLastFrameDuration();

            //Yaw roll
            rotAmount += yaw - prevYaw;
            spinRoll = MathStuff.Lerp(spinRoll, (rotAmount * 0.1f) * ConfigStuff.lookRollMultiplier, 0.8f, lastFrameDuration);
            rotAmount = MathStuff.Lerp(rotAmount, 0, 0.5f, lastFrameDuration);
            spinRoll = MathHelper.clamp(spinRoll, -20.0f, 20.0f);

            //Strafe Roll
            Vec2f velocity2D = MathStuff.get2DRelativeRotation(player.getVelocity(), 360.0f - player.getYaw());
            strafeRoll = MathStuff.Lerp(strafeRoll, (-velocity2D.x * 5) * ConfigStuff.strafeRollMultiplier, 0.8f, lastFrameDuration);
            strafeRoll = MathHelper.clamp(strafeRoll, -20.0f, 20.0f);

            prevYaw = yaw;
        }
        return spinRoll + strafeRoll + SPBRevampedClient.getCameraShake().getCameraZRot();
    }
}
