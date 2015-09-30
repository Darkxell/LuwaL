package display;

import display.states.LevelChooserState;
import display.states.LevelState;
import display.states.MenuState;

/** Abstract class that hold different canvasState objects. */
public abstract class CanvasStatesHolder {

    public static final MenuState MENUSTATE = new MenuState();

    public static final LevelChooserState LEVELCHOOSERSTATE = new LevelChooserState();
    
    public static final LevelState LEVELSTATE = new LevelState();

}
