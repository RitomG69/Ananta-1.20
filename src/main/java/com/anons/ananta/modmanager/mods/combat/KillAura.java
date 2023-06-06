package com.anons.ananta.modmanager.mods.combat;

import com.anons.ananta.modmanager.Categories;
import com.anons.ananta.modmanager.Mod;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;

public class KillAura extends Mod {

    private int hitDelayTimer, randomDelayTimer, switchTimer;

    public KillAura() {
        super("KillAura","Attacks nearby entities",Categories.COMBAT);
    }

    @Override
    public void onUpdate() {
        if (mc.world != null && mc.player != null) {
            for (Entity e : mc.world.getEntities()) {
                if (e.distanceTo(mc.player)<8) {
                    if (delayCheck())attack(e);
                }
            }
        }
    }

    private boolean delayCheck() {
        if (switchTimer > 0) {
            switchTimer--;
            return false;
        }


        return mc.player.getAttackCooldownProgress(0.5f) >= 1;

        /*if (hitDelayTimer >= 0) {
            hitDelayTimer--;
            return false;
        } else {
            hitDelayTimer = hitDelay.get();
        }

        if (randomDelayEnabled.get()) {
            if (randomDelayTimer > 0) {
                randomDelayTimer--;
                return false;
            } else {
                randomDelayTimer = (int) Math.round(Math.random() * randomDelayMax.get());
            }
        }

        return true;*/
    }
    
    private void attack(Entity e) {
        mc.interactionManager.attackEntity(mc.player,e);
        mc.player.swingHand(Hand.MAIN_HAND);
    }
    
}
