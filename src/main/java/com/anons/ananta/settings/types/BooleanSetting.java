package com.anons.ananta.settings.types;

import com.anons.ananta.mods.Mod;
import com.anons.ananta.settings.ISetting;

public class BooleanSetting extends ISetting<Boolean> {
    public BooleanSetting(String name, String description, Mod mod, boolean visible, Boolean value) {
        super(name, description, mod, visible, value);
    }
}
