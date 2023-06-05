package com.anons.ananta.settings;

import com.anons.ananta.mods.Mod;

public class ISetting<T> {

    private final String name;
    private final String description;
    private final Mod mod;
    private boolean visible = true;

    private T value;
    public ISetting(String name, String description, Mod mod, boolean visible, T value) {
        this.name = name;
        this.description = description;
        this.mod = mod;
        this.visible = visible;
        this.value = value;
        mod.getSettings().add(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Mod getMod() {
        return mod;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        mod.onSettingUpdate(this);
    }
}
