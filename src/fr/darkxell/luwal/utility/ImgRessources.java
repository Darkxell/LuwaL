package fr.darkxell.luwal.utility;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

/** Holds the resources images. */
public class ImgRessources {
	
	public static BufferedImage createImage(String url) {
		BufferedImage img = null;
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(url);
			img = ImageIO.read(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static final BufferedImage lock = createImage("lock.png");

}
