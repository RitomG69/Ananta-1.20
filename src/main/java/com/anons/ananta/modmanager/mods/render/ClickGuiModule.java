package com.anons.ananta.modmanager.mods.render;

import com.anons.ananta.Ananta;
import com.anons.ananta.modmanager.Categories;
import com.anons.ananta.modmanager.Mod;
import org.lwjgl.glfw.GLFW;

public class ClickGuiModule extends Mod {
    public ClickGuiModule() {
        super("ClickGui","Open the Gui", Categories.RENDER);
        setKeybind(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Ananta.clickGui.enterGUI();
    }
}
