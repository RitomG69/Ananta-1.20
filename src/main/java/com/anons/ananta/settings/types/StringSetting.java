package com.anons.ananta.settings.types;

import com.anons.ananta.mods.Mod;
import com.anons.ananta.settings.ISetting;

public class StringSetting extends ISetting<String> {
    public StringSetting(String name, String description, Mod mod, boolean visible, String value) {
        super(name, description, mod, visible, value);
    }
}
