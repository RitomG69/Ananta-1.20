package com.anons.ananta.settings.types;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.setting.IStringSetting;

public class StringSetting extends Setting<String> implements IStringSetting {
    public StringSetting(String name, String description, Mod mod, String value) {
        super(name, description, mod, value);
    }
}
