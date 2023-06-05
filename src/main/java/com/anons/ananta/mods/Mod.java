package com.anons.ananta.mods;

import com.anons.ananta.settings.ISetting;

import java.util.ArrayList;
import java.util.List;

public class Mod {
    private final List<ISetting<?>> settings = new ArrayList<>();
    private final String name;
    private final String description;
    private boolean visible = true;
    private boolean toggled = false;

    public Mod(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private void onEnable() {

    }

    private void onDisable() {

    }

    public void onUpdate() {

    }

    public void onSettingUpdate(ISetting<?> s) {

    }

    private void enable() {
        toggled = true;
        onEnable();
    }

    private void disable() {
        toggled = false;
        onDisable();
    }

    private void toggle() {
        if (toggled)disable();
        else enable();
    }

    public List<ISetting<?>> getSettings() {
        return settings;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isToggled() {
        return toggled;
    }
}
