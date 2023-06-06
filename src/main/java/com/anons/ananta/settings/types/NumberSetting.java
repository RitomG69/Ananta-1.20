package com.anons.ananta.settings.types;

import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.Setting;
import com.lukflug.panelstudio.setting.INumberSetting;

public class NumberSetting extends Setting<Number> implements INumberSetting {

    private final Number max,min;
    public NumberSetting(String name, String description, Mod mod,
                         Number value,Number max,Number min) {
        super(name, description, mod, value);
        this.max = max;
        this.min = min;
    }

    public Number getMax() {
        return max;
    }

    public Number getMin() {
        return min;
    }

    @Override
    public double getNumber() {
        return getValue().doubleValue();
    }

    @Override
    public void setNumber(double value) {
        setValue(value);
    }

    @Override
    public double getMaximumValue() {
        return max.doubleValue();
    }

    @Override
    public double getMinimumValue() {
        return min.doubleValue();
    }

    @Override
    public int getPrecision() {
        return 2;
    }
}
