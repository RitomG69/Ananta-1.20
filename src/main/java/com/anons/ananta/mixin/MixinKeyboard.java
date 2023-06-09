package com.anons.ananta.mixin;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.modmanager.ModsManager;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"))
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo info) {
        if (key != GLFW.GLFW_KEY_UNKNOWN) {
            for (Mod m : ModsManager.getMods()) {
                if (key == m.getKeybind())m.toggle();
            }
        }
    }
}
