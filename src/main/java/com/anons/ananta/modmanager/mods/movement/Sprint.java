package com.anons.ananta.modmanager.mods.movement;

import com.anons.ananta.modmanager.Categories;
import com.anons.ananta.modmanager.Mod;
import com.anons.ananta.settings.types.BooleanSetting;

public class Sprint extends Mod {
    public Sprint() {
        super("Sprint","Sprints automatically",Categories.MOVEMENT);
    }

    private final BooleanSetting whenWalking = new BooleanSetting("When Walking",
            "Only sprints when you are walking",this,false);

    @Override
    public void onUpdate() {
        if (whenWalking.getValue()) {
            if (mc.player.forwardSpeed > 0) {
                mc.player.setSprinting(true);
            }
        }
        else {
            mc.player.setSprinting(true);
        }
        super.onUpdate();
    }
}
