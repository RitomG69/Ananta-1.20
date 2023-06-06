package com.anons.ananta.settings.types;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.setting.IEnumSetting;
import com.lukflug.panelstudio.setting.ILabeled;

import java.util.ArrayList;
import java.util.List;

public class ModesSetting extends Setting<String> implements IEnumSetting {

    private final List<String> modes = new ArrayList<>();
    public ModesSetting(String name, String description, Mod mod, String value,String... values) {
        super(name, description, mod, value);
        modes.addAll(List.of(values));
    }

    @Override
    public void increment() {
        int index=modes.indexOf(getValue())+1;
        if (index>=modes.size()) index=0;
        setValue(modes.get(index));
    }

    @Override
    public void decrement() {
        int index=modes.indexOf(getValue())-1;
        if (index<0) index=modes.size()-1;
        setValue(modes.get(index));
    }

    @Override
    public String getValueName() {
        return getValue();
    }

    @Override
    public void setValueIndex(int index) {
        setValue(modes.get(index));
    }

    @Override
    public int getValueIndex() {
        return modes.indexOf(getValue());
    }

    @Override
    public ILabeled[] getAllowedValues() {
        return modes.stream().map(m-> (ILabeled) () -> m).toArray(ILabeled[]::new);
    }
}
