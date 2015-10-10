package management.leveldesign;

import management.Level;
import management.PatternManager;
import management.line.CurrentLevelHolder;
import display.states.LevelChooserState;

/** Static class that holds information for the levels in the game. */
public abstract class LevelManager {

    public static final double CLASSIC_1_ROTATION = 0.3;
    public static final double CLASSIC_1_SCROLL = 0.3;
    public static final int[] CLASSIC_1_PATTERNS = { 1, 2, 3 };

    public static final double CLASSIC_2_ROTATION = 0.4;
    public static final double CLASSIC_2_SCROLL = 0.4;
    public static final int[] CLASSIC_2_PATTERNS = { 1, 2, 3 };

    public static final double CLASSIC_3_ROTATION = 0.5;
    public static final double CLASSIC_3_SCROLL = 0.4;
    public static final int[] CLASSIC_3_PATTERNS = { 1, 2, 3 };

    public static final double CLASSIC_4_ROTATION = 1;
    public static final double CLASSIC_4_SCROLL = 0.5;
    public static final int[] CLASSIC_4_PATTERNS = { 1, 2, 3 };

    public static final double CLASSIC_5_ROTATION = 1.2;
    public static final double CLASSIC_5_SCROLL = 0.6;
    public static final int[] CLASSIC_5_PATTERNS = { 1, 2, 3 };

    /**
     * Sets the current level to the one in the parametters.
     * 
     * @return true if a level has been set, false otherwise.
     * */
    public static boolean setCurrentLevelTo(int leveltype, int levelnumber) {
	switch (leveltype) {
	case LevelChooserState.TYPE_CLASSIC:
	    switch (levelnumber) {
	    case 0:
		CurrentLevelHolder.rotationspeed = CLASSIC_1_ROTATION;
		CurrentLevelHolder.scrollspeed = CLASSIC_1_SCROLL;
		CurrentLevelHolder.currentLevel = new Level(
			PatternManager
				.getPatternArrayFromIDs(CLASSIC_1_PATTERNS));
		return true;
	    case 1:
		CurrentLevelHolder.rotationspeed = CLASSIC_2_ROTATION;
		CurrentLevelHolder.scrollspeed = CLASSIC_2_SCROLL;
		CurrentLevelHolder.currentLevel = new Level(
			PatternManager
				.getPatternArrayFromIDs(CLASSIC_2_PATTERNS));
		return true;
	    case 2:
		CurrentLevelHolder.rotationspeed = CLASSIC_3_ROTATION;
		CurrentLevelHolder.scrollspeed = CLASSIC_3_SCROLL;
		CurrentLevelHolder.currentLevel = new Level(
			PatternManager
				.getPatternArrayFromIDs(CLASSIC_3_PATTERNS));
		return true;
	    case 3:
		CurrentLevelHolder.rotationspeed = CLASSIC_4_ROTATION;
		CurrentLevelHolder.scrollspeed = CLASSIC_4_SCROLL;
		CurrentLevelHolder.currentLevel = new Level(
			PatternManager
				.getPatternArrayFromIDs(CLASSIC_4_PATTERNS));
		return true;
	    case 4:
		CurrentLevelHolder.rotationspeed = CLASSIC_5_ROTATION;
		CurrentLevelHolder.scrollspeed = CLASSIC_5_SCROLL;
		CurrentLevelHolder.currentLevel = new Level(
			PatternManager
				.getPatternArrayFromIDs(CLASSIC_5_PATTERNS));
		return true;
	    }
	    break;
	case LevelChooserState.TYPE_SET:
	    switch (levelnumber) {
	    case 0:

		break;
	    case 1:

		break;
	    case 2:

		break;
	    }
	    break;
	case LevelChooserState.TYPE_SURVIVAL:
	    switch (levelnumber) {
	    case 0:

		break;
	    case 1:

		break;
	    case 2:

		break;
	    }
	    break;
	}
	return false;
    }
}
