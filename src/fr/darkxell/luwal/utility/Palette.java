package fr.darkxell.luwal.utility;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;

public class Palette {

	public static Font createfont(String url, float size) {
		Font f = null;
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(url);
			f = Font.createFont(Font.TRUETYPE_FONT, is);
			is.close();
			f = f.deriveFont(size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static final Font sheeping_dogs_big = createfont("Sheeping Dogs.ttf", 150f);
	public static final Font sheeping_dogs_medium = createfont("Sheeping Dogs.ttf", 100f);
	public static final Font sheeping_dogs_small = createfont("Sheeping Dogs.ttf", 75f);
	public static final Font sheeping_dogs_smaller = createfont("Sheeping Dogs.ttf", 50f);
	public static final Font sheeping_dogs_tiny = createfont("Sheeping Dogs.ttf", 30f);

	public static final Color BACKGROUND_GREY = new Color(150, 150, 150);
	public static final Color BACKGROUND_GREY_DARK = new Color(100, 100, 100);
	public static final Color LIGHT_GREY = new Color(200, 200, 200);
	public static final Color GHOST_GREY = new Color(165, 165, 165);

}
