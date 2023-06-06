package com.anons.ananta.gui;

import com.anons.ananta.modmanager.ModsManager;
import com.anons.ananta.modmanager.mods.render.ClickGuiModule;
import com.anons.ananta.settings.types.ColorSetting;
import com.lukflug.panelstudio.base.Animation;
import com.lukflug.panelstudio.base.Context;
import com.lukflug.panelstudio.base.SettingsAnimation;
import com.lukflug.panelstudio.component.IResizable;
import com.lukflug.panelstudio.component.IScrollSize;
import com.lukflug.panelstudio.container.GUI;
import com.lukflug.panelstudio.layout.*;
import com.lukflug.panelstudio.mc20.MinecraftGUI;
import com.lukflug.panelstudio.popup.MousePositioner;
import com.lukflug.panelstudio.popup.PanelPositioner;
import com.lukflug.panelstudio.popup.PopupTuple;
import com.lukflug.panelstudio.setting.IClient;
import com.lukflug.panelstudio.theme.IColorScheme;
import com.lukflug.panelstudio.theme.ITheme;
import com.lukflug.panelstudio.theme.ImpactTheme;
import com.lukflug.panelstudio.widget.ITextFieldKeys;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.function.*;

public class ClickGui extends MinecraftGUI {

    private ClickGuiModule mod;
    private static final int WIDTH=120,HEIGHT=12,DISTANCE=6;
    private GUIInterface guiInterface;
    private GUI gui;

    private IClient psClient;

    public ClickGui() {

        psClient = new ModsManager();
        mod = ModsManager.getMod(ClickGuiModule.class);
        guiInterface = new GUIInterface(true) {
            @Override
            protected String getResourcePrefix() {
                return "ananta:";
            }
        };

        ITheme theme = new ImpactTheme(new ThemeScheme(),9,5);

        gui = new GUI(guiInterface,theme.getDescriptionRenderer(), new MousePositioner(new Point(10,10)));

        // Defining function keys ...
        IntPredicate keybindKey= scancode->scancode==GLFW.GLFW_KEY_DELETE;
        IntPredicate charFilter=character->{
            return character>=' ';
        };

        // Defining resize behavior ...
        IntFunction<IResizable> resizable= width->new IResizable() {
            Dimension size=new Dimension(width,320);

            @Override
            public Dimension getSize() {
                return new Dimension(size);
            }

            @Override
            public void setSize (Dimension size) {
                this.size.width=size.width;
                this.size.height=size.height;
                if (size.width<75) this.size.width=75;
                if (size.height<50) this.size.height=50;
            }
        };
        // Defining scroll behavior ...
        Function<IResizable,IScrollSize> resizableHeight= size->new IScrollSize() {
            @Override
            public int getScrollHeight (Context context, int componentHeight) {
                return size.getSize().height;
            }
        };

        // Creating animation ...
        Supplier<Animation> animation=()->new SettingsAnimation(()->100,()->guiInterface.getTime()); //TODO change 100
        ITextFieldKeys keys=new ITextFieldKeys() {
            @Override
            public boolean isBackspaceKey (int scancode) {
                return scancode== GLFW.GLFW_KEY_BACKSPACE;
            }

            @Override
            public boolean isDeleteKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_DELETE;
            }

            @Override
            public boolean isInsertKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_INSERT;
            }

            @Override
            public boolean isLeftKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_LEFT;
            }

            @Override
            public boolean isRightKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_RIGHT;
            }

            @Override
            public boolean isHomeKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_HOME;
            }

            @Override
            public boolean isEndKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_END;
            }

            @Override
            public boolean isCopyKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_C;
            }

            @Override
            public boolean isPasteKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_V;
            }

            @Override
            public boolean isCutKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_X;
            }

            @Override
            public boolean isAllKey (int scancode) {
                return scancode==GLFW.GLFW_KEY_A;
            }
        };

        BiFunction<Context,Integer,Integer> scrollHeight=(context, componentHeight)->Math.min(componentHeight,Math.max(HEIGHT*4,ClickGui.this.height-context.getPos().y-HEIGHT));
        PopupTuple popupType=new PopupTuple(new PanelPositioner(new Point(0,0)),false,new IScrollSize() {
            @Override
            public int getScrollHeight (Context context, int componentHeight) {
                return scrollHeight.apply(context,componentHeight);
            }
        });
        IComponentGenerator generator=new ComponentGenerator(keybindKey,charFilter,keys);

        // Classic Panel
        IComponentAdder classicPanelAdder=new PanelAdder(gui,false,()->true, title->"classicPanel_"+title) {
            @Override
            protected IResizable getResizable (int width) {
                return resizable.apply(width);
            }

            @Override
            protected IScrollSize getScrollSize (IResizable size) {
                return resizableHeight.apply(size);
            }
        };
        ILayout classicPanelLayout=new PanelLayout(WIDTH,new Point(DISTANCE,DISTANCE),(WIDTH+DISTANCE)/2,HEIGHT+DISTANCE,animation, level-> ChildUtil.ChildMode.DOWN, level-> ChildUtil.ChildMode.DOWN,popupType);
        classicPanelLayout.populateGUI(classicPanelAdder,generator,psClient,theme);
    }

    @Override
    protected GUI getGUI() {
        return gui;
    }

    @Override
    protected GUIInterface getInterface() {
        return guiInterface;
    }

    @Override
    protected int getScrollSpeed() {
        return 10; //TODO
    }

    private class ThemeScheme implements IColorScheme {

        @Override
        public void createSetting (ITheme theme, String name, String description, boolean hasAlpha, boolean allowsRainbow, Color color, boolean rainbow) {
            new ColorSetting(name,name,description,mod,true,color,hasAlpha,allowsRainbow,rainbow);
        }

        @Override
        public Color getColor (String name) {
            ColorSetting s = (ColorSetting) mod.getSettings().filter(setting->setting.getDisplayName().equals(name)).findFirst().orElse(null);
            assert s != null;
            return s.getValue();
        }
    }
}
