package ressources;

import java.awt.Color;

import management.line.CurrentLevelHolder;

/** Static clasds that holds diferent colors to be used in the program. */
public abstract class Palette {

    public static final Color BACKGROUND_GREY = new Color(150, 150, 150);
    public static final Color BACKGROUND_GREY_DARK = new Color(100, 100, 100);
    public static final Color LIGHT_GREY = new Color(200, 200, 200);

    public static final Color L1_LineColor = new Color(130, 205, 225);
    public static final Color L1_BackgroundColor = new Color(235, 255, 255);
    public static final Color L1_PlatformColor = new Color(225, 255, 255);
    public static final Color L1_SpikesColor = new Color(73, 88, 224);
    public static final Color L1_PlayerColor = new Color(114, 111, 251);
    public static final Color L1_PlayerGhostColor = new Color(205, 235, 235);
    public static final Color L1_LevelFontColor = new Color(103, 118, 254);

    public static final Color L2_LineColor = new Color(247, 76, 76);
    public static final Color L2_BackgroundColor = new Color(255, 235, 255);
    public static final Color L2_PlatformColor = new Color(255, 235, 255);
    public static final Color L2_SpikesColor = new Color(255, 235, 255);
    public static final Color L2_PlayerColor = new Color(255, 150, 150);
    public static final Color L2_PlayerGhostColor = new Color(255, 96, 96);
    public static final Color L2_LevelFontColor = new Color(217, 46, 46);

    public static final Color L3_LineColor = new Color(74, 226, 63);
    public static final Color L3_BackgroundColor = new Color(196, 255, 173);
    public static final Color L3_PlatformColor = new Color(196, 255, 173);
    public static final Color L3_SpikesColor = new Color(196, 255, 173);
    public static final Color L3_PlayerColor = new Color(76, 173, 48);
    public static final Color L3_PlayerGhostColor = new Color(54, 206, 43);
    public static final Color L3_LevelFontColor = new Color(44, 196, 33);

    public static final Color L4_LineColor = new Color(130, 205, 225);
    public static final Color L4_BackgroundColor = new Color(0, 0, 0);
    public static final Color L4_PlatformColor = new Color(225, 255, 255);
    public static final Color L4_SpikesColor = new Color(73, 88, 224);
    public static final Color L4_PlayerColor = new Color(114, 111, 251);
    public static final Color L4_PlayerGhostColor = new Color(205, 235, 235);
    public static final Color L4_LevelFontColor = new Color(103, 118, 254);

    public static final Color L5_LineColor = new Color(247, 76, 76);
    public static final Color L5_BackgroundColor = new Color(0, 0, 0);
    public static final Color L5_PlatformColor = new Color(255, 235, 255);
    public static final Color L5_SpikesColor = new Color(255, 235, 255);
    public static final Color L5_PlayerColor = new Color(255, 150, 150);
    public static final Color L5_PlayerGhostColor = new Color(255, 96, 96);
    public static final Color L5_LevelFontColor = new Color(217, 46, 46);

    public static final Color L6_LineColor = new Color(74, 226, 63);
    public static final Color L6_BackgroundColor = new Color(0, 0, 0);
    public static final Color L6_PlatformColor = new Color(196, 255, 173);
    public static final Color L6_SpikesColor = new Color(196, 255, 173);
    public static final Color L6_PlayerColor = new Color(76, 173, 48);
    public static final Color L6_PlayerGhostColor = new Color(54, 206, 43);
    public static final Color L6_LevelFontColor = new Color(44, 196, 33);

    /**
     * Sets the static colors in the current level holder to a set of colors in
     * the palette.
     */
    public static void setcurrentlevelcolors(int levelnumber) {
	switch (levelnumber) {
	case 1:
	    CurrentLevelHolder.LineColor = L1_LineColor;
	    CurrentLevelHolder.BackgroundColor = L1_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L1_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L1_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L1_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L1_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L1_LevelFontColor;
	    break;
	case 2:
	    CurrentLevelHolder.LineColor = L2_LineColor;
	    CurrentLevelHolder.BackgroundColor = L2_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L2_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L2_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L2_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L2_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L2_LevelFontColor;
	    break;
	case 3:
	    CurrentLevelHolder.LineColor = L3_LineColor;
	    CurrentLevelHolder.BackgroundColor = L3_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L3_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L3_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L3_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L3_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L3_LevelFontColor;
	    break;
	case 4:
	    CurrentLevelHolder.LineColor = L4_LineColor;
	    CurrentLevelHolder.BackgroundColor = L4_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L4_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L4_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L4_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L4_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L4_LevelFontColor;
	    break;
	case 5:
	    CurrentLevelHolder.LineColor = L5_LineColor;
	    CurrentLevelHolder.BackgroundColor = L5_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L5_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L5_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L5_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L5_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L5_LevelFontColor;
	    break;
	case 6:
	    CurrentLevelHolder.LineColor = L6_LineColor;
	    CurrentLevelHolder.BackgroundColor = L6_BackgroundColor;
	    CurrentLevelHolder.PlatformColor = L6_PlatformColor;
	    CurrentLevelHolder.SpikesColor = L6_SpikesColor;
	    CurrentLevelHolder.PlayerColor = L6_PlayerColor;
	    CurrentLevelHolder.PlayerGhostColor = L6_PlayerGhostColor;
	    CurrentLevelHolder.LevelFontColor = L6_LevelFontColor;
	    break;
	default:
	    CurrentLevelHolder.LineColor = BACKGROUND_GREY;
	    CurrentLevelHolder.BackgroundColor = BACKGROUND_GREY_DARK;
	    CurrentLevelHolder.PlatformColor = BACKGROUND_GREY_DARK;
	    CurrentLevelHolder.SpikesColor = BACKGROUND_GREY_DARK;
	    CurrentLevelHolder.PlayerColor = BACKGROUND_GREY_DARK;
	    CurrentLevelHolder.PlayerGhostColor = LIGHT_GREY;
	    CurrentLevelHolder.LevelFontColor = LIGHT_GREY;
	    break;
	}
    }
}
