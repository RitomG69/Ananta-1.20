package com.anons.ananta.mixin;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.modmanager.ModsManager;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    private void onTick(CallbackInfo info) {
        for (Mod m : ModsManager.getMods()) {
            if (m.isToggled()) {
                m.onUpdate();
            }
        }
    }
}
