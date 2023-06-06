package com.anons.ananta.modmanager;

import com.anons.ananta.modmanager.mods.combat.KillAura;
import com.anons.ananta.modmanager.mods.movement.Sprint;
import com.anons.ananta.modmanager.mods.player.AutoEat;
import com.anons.ananta.modmanager.mods.render.ClickGuiModule;
import com.lukflug.panelstudio.setting.ICategory;
import com.lukflug.panelstudio.setting.IClient;
import com.lukflug.panelstudio.setting.IModule;

import java.util.*;
import java.util.stream.Stream;

public class ModsManager implements IClient {

    private static final List<Mod> mods = new ArrayList<>();
    private static final Map<Class<? extends Mod>,Mod> modsMap = new HashMap<>();

    public static void init() {
        add(new ClickGuiModule());
        add(new KillAura());
        add(new AutoEat());
        add(new Sprint());
    }

    private static void add(Mod m) {
        if (!mods.contains(m)) {
            mods.add(m);
            modsMap.put(m.getClass(),m);
        }
    }

    @SuppressWarnings("unchecked")
    public static  <T extends Mod> T getMod(Class<T> klass) {
        return (T) modsMap.get(klass);
    }

    public static List<Mod> getMods() {
        return mods;
    }

    public static List<Mod> getModsInCategory(Categories c) {
        return getMods().stream().filter(mod -> mod.getCategory()==c).toList();
    }

    @Override
    public Stream<ICategory> getCategories() {
        return Arrays.stream(Categories.values()).map(c -> new ICategory() {
            @Override
            public Stream<IModule> getModules() {
                return getModsInCategory(c).stream().map(module -> module);
            }

            @Override
            public String getDisplayName() {
                return c.getName();
            }
        });
    }
}
