package fr.darkxell.luwal.utility;

import java.awt.Font;
import java.io.InputStream;

public class FontsHolder {

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

}
