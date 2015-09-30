package utils;

import java.awt.Font;
import java.net.URL;

/** Static util class to build Font objects from a file. */
public abstract class FontBuilder {

    /**
     * Builds a font object using a link to a .ttf or .otf file. Static method.
     * The returned font is plain, and has a height of 20 px.
     * 
     * @param url
     *            The Absolute/Relative url to the file. Do not include the
     *            "file:" in the URL.
     * */
    public static Font createfont(String url) {
	URL fontUrl;
	try {
	    fontUrl = new URL("file:" + url);
	    Font font = Font.createFont(Font.TRUETYPE_FONT,
		    fontUrl.openStream());
	    font = font.deriveFont(Font.PLAIN, 20);
	    return font;
	} catch (Exception e) {
	    return null;
	}
    }
}
