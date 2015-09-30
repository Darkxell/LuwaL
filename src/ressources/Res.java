package ressources;

import java.awt.Font;

import utils.FontBuilder;

/**
 * Abstract class that holds different static link to usual ofjects like fonts
 * and images.
 */
public abstract class Res {

    /** The filepath to the ressource folder. */
    public static final String FOLDERPATH = "C:\\Users\\Darkxell_mc\\Desktop\\Line\\";
    // public static final String FOLDERPATH = "";

    public static final Font MAIN_FONT_SMALL = FontBuilder.createfont(
	    FOLDERPATH + "misc\\font.otf").deriveFont(10f);
    public static final Font MAIN_FONT_NORMAL = FontBuilder.createfont(
	    FOLDERPATH + "misc\\font.otf").deriveFont(30f);
    public static final Font MAIN_FONT_TALL = FontBuilder.createfont(
	    FOLDERPATH + "misc\\font.otf").deriveFont(80f);

}
