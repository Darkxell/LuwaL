package fr.darkxell.luwal.gamestates;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import fr.darkxell.luwal.main.DState;
import fr.darkxell.luwal.main.DisplayLine;
import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.utility.KeysConfig;
import fr.darkxell.luwal.utility.FontsHolder;

/**
 * State of the game that appears on the player death or suicide at the end of a
 * level.
 */
public class GameOverState extends DState {

	/** The level played before. */
	private Level from;
	/** The time (score) displayed. */
	private double time;

	private int counter = 0;

	/** Creates a new Gameoverstate from the wanted level. */
	public GameOverState(Level from, double time) {
		this.from = from;
		this.time = time;
	}

	@Override
	public void update() {
		DisplayLine.update();
		if (counter == 0)
			Launcher.soundManager.setBackgroundMusic(null);
		++counter;
	}

	@Override
	public BufferedImage getPrint() {

		BufferedImage buffer = new BufferedImage(Launcher.gameframe.getWidth(), Launcher.gameframe.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		// Displays the background and
		g2d.setColor(from.meta.getBackgroundColor());
		g2d.fillRect(0, 0, buffer.getWidth(), buffer.getWidth());
		DisplayLine.print(g2d, from, from.meta.getLineColor());
		// Displays the death pannel.
		// counter from 0 to 50 (half a sec animation).
		g2d.setColor(from.meta.getBackgroundColor());
		int pos = counter > 50 ? buffer.getWidth() / 3 : buffer.getWidth() / 150 * counter;
		g2d.fill(new Polygon(
				new int[] { buffer.getWidth() - pos - 20, buffer.getWidth() - pos, buffer.getWidth() - pos * 2,
						buffer.getWidth() - pos * 2 - 20 },
				new int[] { 0, 0, buffer.getHeight(), buffer.getHeight() }, 4));
		g2d.setColor(from.meta.getLineColor());
		g2d.fill(
				new Polygon(
						new int[] { buffer.getWidth() - pos, buffer.getWidth(), buffer.getWidth(),
								buffer.getWidth() - pos * 2 },
						new int[] { 0, 0, buffer.getHeight(), buffer.getHeight() }, 4));
		// Displays the time
		if (counter > 50) {
			g2d.setColor(from.meta.getPlayerColor());
			g2d.setFont(FontsHolder.sheeping_dogs_medium);
			g2d.drawString("Time : " + time, pos * 2 - 20, buffer.getHeight() / 5 * 4);
			g2d.drawString("Game Over", pos * 2 + 10, buffer.getHeight() / 3);

		}
		// end
		g2d.dispose();
		return buffer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeysConfig.back) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new LevelSelectState();
		} else if (e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2) {
			DisplayLine.prepareRotativeDash();
			try {
				Launcher.gamestate = new PlayState(from.getClass().newInstance());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
