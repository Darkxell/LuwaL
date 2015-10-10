package management.line;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import display.CanvasStatesHolder;
import main.Main;
import management.Spike;

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
    private static int rectheight = 200;
    private static double rotation = 0;
    private static int dasher = 0;
    /**
     * Laners are booleans that determines the mouvement direction of a certain
     * item.
     */
    private static boolean heightLaner = true;
    private static boolean sizeLaner = true;
    private static boolean rotatorLaner = true;

    /** Gets a graphic object and prints the line on it. */
    public static void print(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g.setColor(CurrentLevelHolder.BackgroundColor);
	g.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());
	g.setColor(CurrentLevelHolder.LineColor);
	Rectangle r = new Rectangle(-(Main.frame.getWidth() / 2),
		(rectY - (rectheight / 2)), Main.frame.getWidth() * 2,
		rectheight);

	AffineTransform t = new AffineTransform();
	t.rotate(Math.toRadians(rotation), r.getX() + r.width / 2, r.getY()
		+ r.height / 2);
	AffineTransform old = g2.getTransform();
	g2.transform(t);
	g2.fill(r);
	// Draws the level on the line rectangle.
	try {
	    double heightpx = rectheight / 9.0;
	    if (Main.frame.getFullCanvas().state == CanvasStatesHolder.LEVELSTATE) {
		g2.setColor(CurrentLevelHolder.PlayerGhostColor);
		g2.fillRect(
			Main.frame.getWidth() / 3,
			(int) (rectY + (CurrentLevelHolder.playerY * heightpx) - (heightpx / 2)),
			(int) heightpx, (int) heightpx);

		g2.setColor(CurrentLevelHolder.PlayerColor);
		g2.fillRect(
			Main.frame.getWidth() / 3,
			(int) (rectY
				+ ((CurrentLevelHolder.isSliding ? (CurrentLevelHolder.playerSide ? CurrentLevelHolder.playerY + 2
					: CurrentLevelHolder.playerY - 2)
					: CurrentLevelHolder.playerY) * heightpx) - (heightpx / 2)),
			(int) heightpx, (int) heightpx);
	    }
	    for (int i = 0; i < CurrentLevelHolder.currentLevel
		    .getLinesAmmount(); i++) {
		int xline = (int) ((Main.frame.getWidth() / 3)
			+ ((double) CurrentLevelHolder.currentLevel.getLine(i)
				.getX() * widthpx) - ((double) CurrentLevelHolder.playerX * widthpx));
		int yline = (int) (rectY
			+ ((CurrentLevelHolder.currentLevel.getLine(i).getY()) * heightpx) - (heightpx / 2));
		g2.setColor(CurrentLevelHolder.PlatformColor);
		g2.fillRect(xline, yline - 2, CurrentLevelHolder.currentLevel
			.getLine(i).getLength() * widthpx + 2,
			(int) heightpx + 4);

		try {
		    for (int j = 0; j < CurrentLevelHolder.currentLevel
			    .getLine(i).getSpikes().length; j++) {
			try {
			    Spike s = CurrentLevelHolder.currentLevel
				    .getLine(i).getSpikes()[j];
			    g2.setColor(CurrentLevelHolder.SpikesColor);
			    g2.fillRect(
				    (int) (xline + (s.getOffset() * widthpx)),
				    (int) (yline + (s.getSide() ? -heightpx
					    : heightpx)),
				    (int) (s.getWidth() * widthpx),
				    (int) heightpx);

			} catch (Exception e) {
			}
		    }
		} catch (Exception e) {
		}
	    }
	} catch (Exception e) {
	}

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
	if (rectheight > Main.frame.getHeight() / 2)
	    sizeLaner = false;
	if (rectheight < Main.frame.getHeight() / 4)
	    sizeLaner = true;
	if (sizeLaner)
	    rectheight++;
	else
	    rectheight--;
	// heightLaner
	if (rectY - (rectheight / 2) < Main.frame.getHeight() * 0.15)
	    heightLaner = true;
	if (rectY + (rectheight / 2) > Main.frame.getHeight() * 0.85)
	    heightLaner = false;
	if (heightLaner)
	    rectY++;
	else
	    rectY--;
	// rotatorLaner
	if (rotatorLaner) {
	    rotation += CurrentLevelHolder.rotationspeed;
	    if (dasher > 0) {
		int torotate = dasher / 10;
		rotation += torotate;
		dasher = dasher / 2;
	    }
	} else {
	    rotation -= CurrentLevelHolder.rotationspeed;
	    if (dasher > 0) {
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
