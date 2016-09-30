package fr.darkxell.luwal.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import fr.darkxell.luwal.gamestates.PlayState;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.utility.Palette;

/**
 * Static class that holds the line position and display methods to print it.
 * can be updated using the <code>update()</code> method.
 */
public abstract class DisplayLine {

	/**
	 * A constant value that sets how much rotation frames will be actives in a
	 * normal rotation dash.
	 */
	private static final int ROTATOR = 512;
	private static final int widthpx = 30;

	private static int rectY = 300;
	private static int rectheight = 0;
	private static double rotation = 0;
	private static int dasher = 0;
	/**
	 * Laners are booleans that determines the movement direction of a certain
	 * item.
	 */
	private static boolean heightLaner = true;
	private static boolean sizeLaner = true;
	private static boolean rotatorLaner = true;

	/** Gets a graphic object and prints the line on it. */
	public static void print(Graphics g, Level l) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Palette.BACKGROUND_GREY);
		Rectangle r = new Rectangle(-(Launcher.gameframe.getWidth() / 2), (rectY - (rectheight / 2)),
				Launcher.gameframe.getWidth() * 2, rectheight);

		AffineTransform t = new AffineTransform();
		t.rotate(Math.toRadians(rotation), r.getX() + r.width / 2, r.getY() + r.height / 2);
		AffineTransform old = g2.getTransform();
		g2.transform(t);
		g2.fill(r);
		// Draws the level on the line rectangle.
		if (l != null)
			l.display(g2, rectheight, rectY, widthpx);

		g2.setTransform(old);

	}

	/** Updates the line to the next frame. */
	public static void update() {
		if (Math.random() < 0.01)
			heightLaner = !heightLaner;
		if (Math.random() < 0.01)
			sizeLaner = !sizeLaner;
		if (Math.random() < 0.01)
			rotatorLaner = !rotatorLaner;
		// SizeLaner
		if (rectheight > Launcher.gameframe.getHeight() / 2)
			sizeLaner = false;
		if (rectheight < Launcher.gameframe.getHeight() / 4)
			sizeLaner = true;
		if (sizeLaner)
			rectheight++;
		else
			rectheight--;
		// heightLaner
		if (rectY - (rectheight / 2) < Launcher.gameframe.getHeight() * 0.15)
			heightLaner = true;
		if (rectY + (rectheight / 2) > Launcher.gameframe.getHeight() * 0.85)
			heightLaner = false;
		if (heightLaner)
			rectY++;
		else
			rectY--;
		// rotatorLaner
		double rotator = Launcher.gamestate instanceof PlayState
				? ((PlayState) Launcher.gamestate).getLevel().meta.getRotateSpeed() : 0.3;
		if (rotatorLaner) {
			rotation += rotator;
			if (dasher > 1) {
				int torotate = dasher / 10;
				rotation += torotate;
				dasher = dasher / 2;
			}
		} else {
			rotation -= rotator;
			if (dasher > 1) {
				int torotate = dasher / 10;
				rotation -= torotate;
				dasher = dasher / 2;
			}
		}
	}

	

	/** Prepares a rotation dash. */
	public static void prepareRotativeDash() {
		dasher = ROTATOR;
	}

}
