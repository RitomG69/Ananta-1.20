package com.anons.ananta.settings.types;

import com.anons.ananta.mods.Mod;
import com.anons.ananta.settings.ISetting;

public class NumberSetting extends ISetting<Number> {

    private final Number max,min;
    public NumberSetting(String name, String description, Mod mod, boolean visible,
                         Number value,Number max,Number min) {
        super(name, description, mod, visible, value);
        this.max = max;
        this.min = min;
    }

    public Number getMax() {
        return max;
    }

    public Number getMin() {
        return min;
    }
}
