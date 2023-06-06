package com.anons.ananta.modmanager;

import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.base.IToggleable;
import com.lukflug.panelstudio.setting.IModule;
import com.lukflug.panelstudio.setting.ISetting;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Mod implements IModule {
    private final List<Setting<?>> settings = new ArrayList<>();

    protected final MinecraftClient mc = MinecraftClient.getInstance();
    private final String name;
    private final String description;

    private final Categories category;
    private IBoolean visible = ()->true;
    private boolean toggled = false;

    private int keybind = GLFW.GLFW_KEY_UNKNOWN;

    public Mod(String name, String description, Categories category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    protected void onEnable() {

    }

    protected void onDisable() {

    }

    public void onUpdate() {

    }

    public void onSettingUpdate(Setting<?> s) {

    }

    private void enable() {
        toggled = true;
        onEnable();
    }

    private void disable() {
        toggled = false;
        onDisable();
    }

    public void toggle() {
        if (toggled)disable();
        else enable();
    }

    @Override
    public IToggleable isEnabled() {
        return new IToggleable() {
            @Override
            public void toggle() {
                Mod.this.toggle();
            }

            @Override
            public boolean isOn() {
                return Mod.this.toggled;
            }
        };
    }

    @Override
    public Stream<ISetting<?>> getSettings() {
        return settings.stream().filter(setting -> setting instanceof ISetting<?>).sorted(Comparator.comparing(Setting::getDisplayName)).map(setting->(ISetting<?>)setting);
    }
    public List<Setting<?>> getModSettings() {
        return settings;
    }
    public Categories getCategory() {
        return category;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public IBoolean isVisible() {
        return visible;
    }

    public void setVisible(IBoolean visible) {
        this.visible = visible;
    }

    public boolean isToggled() {
        return toggled;
    }

    public int getKeybind() {
        return keybind;
    }

    public void setKeybind(int keybind) {
        this.keybind = keybind;
    }
}
