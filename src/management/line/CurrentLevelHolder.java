package management.line;

import java.awt.Color;

import ressources.Palette;
import management.Level;

/**
 * Abstract vlass that holds a playing level, the player position and the player
 * progression.
 */
public abstract class CurrentLevelHolder {

    public static Color LineColor = Palette.BACKGROUND_GREY;
    public static Color BackgroundColor = Palette.BACKGROUND_GREY_DARK;
    public static Color PlatformColor = Palette.BACKGROUND_GREY_DARK;
    public static Color SpikesColor = Palette.BACKGROUND_GREY_DARK;
    public static Color PlayerColor = Palette.BACKGROUND_GREY_DARK;
    public static Color PlayerGhostColor = Palette.LIGHT_GREY;
    public static Color LevelFontColor = Palette.LIGHT_GREY;

    /** The time spent alive on the current level. */
    public static double time = 0;
    /**
     * The current playing level. Can be null if no level is playing. Note that
     * this doesn't hold level progression.
     */
    public static Level currentLevel = null;
    /** The X position of the player in the level. */
    public static double playerX = -20;
    /** The Y position of the player in the level. */
    public static double playerY = 1;
    /**
     * The player side in the level. Is false if the player gravity is normal,
     * true if the gravity is reversed.
     */
    public static boolean playerSide = false;
    /**
     * Is true if the player is actually sliding. If thez player is sliding it's
     * position has a 2 height offset, making him appear on the other side of
     * the platform he is riding.
     */
    public static boolean isSliding = false;
    /** The current rotation speed. */
    public static double rotationspeed = 0.3;
    /** the current sliding speed */
    public static double scrollspeed = 0.3;
}
