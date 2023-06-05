package com.anons.ananta.settings.types;

import com.anons.ananta.mods.Mod;
import com.anons.ananta.settings.ISetting;

import java.util.ArrayList;
import java.util.List;

public class ModesSetting extends ISetting<String> {

    private final List<String> modes = new ArrayList<>();
    public ModesSetting(String name, String description, Mod mod, boolean visible, String value,String... values) {
        super(name, description, mod, visible, value);
        modes.addAll(List.of(values));
    }
}
