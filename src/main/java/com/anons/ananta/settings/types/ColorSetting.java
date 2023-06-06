package com.anons.ananta.settings.types;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.setting.IColorSetting;

import java.awt.*;

public class ColorSetting extends Setting<Color> implements IColorSetting {

    private boolean hasAlpha;
    private boolean allowsRainbow;
    private boolean rainbow;
    public ColorSetting(String name, String description, Mod mod, Color value) {
        super(name, description, mod, value);
        this.hasAlpha = true;
        this.allowsRainbow = true;
        this.rainbow = false;
    }

    public ColorSetting(String name,String configName, String description, Mod mod, boolean visible, Color value, boolean hasAlpha, boolean allowsRainbow, boolean rainbow) {
        super(name, configName,description, mod, ()->visible, value);
        this.hasAlpha = hasAlpha;
        this.allowsRainbow = allowsRainbow;
        this.rainbow = rainbow;
    }

    @Override
    public Color getColor() {
        return getValue();
    }

    @Override
    public boolean getRainbow() {
        return rainbow;
    }

    @Override
    public void setRainbow(boolean rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public boolean hasAlpha() {
        return this.hasAlpha;
    }

    @Override
    public boolean allowsRainbow() {
        return this.allowsRainbow;
    }
}
