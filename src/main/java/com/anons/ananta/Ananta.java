package com.anons.ananta;

import com.anons.ananta.gui.ClickGui;
import com.anons.ananta.modmanager.ModsManager;
import net.fabricmc.api.ClientModInitializer;

public class Ananta implements ClientModInitializer {

    public static String modName = "Ananta";
    public static ClickGui clickGui;
    @Override
    public void onInitializeClient() {
        ModsManager.init();
        clickGui = new ClickGui();
    }
}
