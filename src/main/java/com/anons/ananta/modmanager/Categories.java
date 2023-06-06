package com.anons.ananta.modmanager;

import com.lukflug.panelstudio.setting.ICategory;
import com.lukflug.panelstudio.setting.IModule;

import java.util.stream.Stream;

public enum Categories{

        COMBAT("Combat"),PLAYER("Player"),MOVEMENT("Movement"),RENDER("Render");

        private final String name;
    Categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
