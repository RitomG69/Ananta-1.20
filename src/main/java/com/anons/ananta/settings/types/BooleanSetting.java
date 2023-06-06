package com.anons.ananta.settings.types;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.setting.IBooleanSetting;
import com.lukflug.panelstudio.setting.ISetting;

public class BooleanSetting extends Setting<Boolean> implements IBooleanSetting {
    public BooleanSetting(String name, String description, Mod mod, Boolean value) {
        super(name, description, mod, value);
    }

    @Override
    public void toggle() {
        setValue(!getValue());
    }

    @Override
    public boolean isOn() {
        return getValue();
    }

}
