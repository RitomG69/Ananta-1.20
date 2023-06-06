package com.anons.ananta.settings;

import com.anons.ananta.modmanager.Mod;
import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.setting.ILabeled;

import java.util.ArrayList;
import java.util.List;

public class Setting<T> implements ILabeled {

    private final String name;

    private final String configName;
    private final String description;
    private final Mod mod;
    private IBoolean visible;

    private final List<Setting<?>> subSettings = new ArrayList<>();

    private T value;
    public Setting(String name, String description, Mod mod, T value) {
        this(name,name,description,mod,()->true,value);
    }

    public Setting(String name, String description, Mod mod, IBoolean visible, T value) {
        this(name,name,description,mod,visible,value);
    }

    public Setting(String name, String configName, String description, Mod mod, IBoolean visible, T value) {
        this.name = name;
        this.configName = configName;
        this.description = description;
        this.mod = mod;
        this.visible = visible;
        this.value = value;
        mod.getModSettings().add(this);
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Mod getMod() {
        return mod;
    }

    public IBoolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = ()->visible;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        mod.onSettingUpdate(this);
    }

    public String getConfigName() {
        return configName;
    }
}
