package fr.darkxell.luwal.gamestates;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import fr.darkxell.luwal.main.DState;
import fr.darkxell.luwal.main.DisplayLine;
import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.utility.FontsHolder;
import fr.darkxell.luwal.utility.KeysConfig;

/** The state where the player actually plays the game. */
public class PlayState extends DState {

	/** The level object being played. */
	private Level level;
	/**
	 * Timer that counts how much time the player survived on this level. This
	 * value is in centiseconds.
	 */
	private int timesec = 0;

	/** Builds a new playable state using a level. */
	public PlayState(Level level) {
		this.level = level;
	}

	@Override
	public void update() {
		DisplayLine.update();
		level.update();
		if(timesec==0)
			Launcher.soundManager.setBackgroundMusic(this.level.meta.getLevelSong());
		++timesec;
		// If the player has died, level.killed is set to true.
		// => End this state.
		if (level.killed) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new GameOverState(this.level, (double) (timesec) / 100);
		}
	}

	@Override
	public BufferedImage getPrint() {
		BufferedImage buffer = new BufferedImage(Launcher.gameframe.getWidth(), Launcher.gameframe.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		// Background and line display
		g2d.setColor(level.meta.getBackgroundColor());
		g2d.fillRect(0, 0, buffer.getWidth(), buffer.getWidth());
		DisplayLine.print(g2d, level, level.meta.getLineColor());
		// Displays the time.
		g2d.setColor(level.meta.getLineColor());
		g2d.setFont(FontsHolder.sheeping_dogs_small);
		String time = "" + timesec / 100;
		int height = 80, width = g2d.getFontMetrics().stringWidth(time) + 40;
		g2d.fillRect(buffer.getWidth() - width, 0, width, height);
		g2d.fill(new Polygon(
				new int[] { buffer.getWidth() - width - height, buffer.getWidth() - width, buffer.getWidth() - width },
				new int[] { 0, 0, height }, 3));
		g2d.setColor(level.meta.getBackgroundColor());
		g2d.drawString(time, buffer.getWidth() - width + 20, height - 10);

		// return
		g2d.dispose();
		return buffer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2)
			this.level.getPlayer().press();
		if (e.getKeyCode() == KeysConfig.back) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new GameOverState(this.level, (double) (timesec) / 100);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2)
			this.level.getPlayer().release();

	}

	/** Returns the level of this PlayState. */
	public Level getLevel() {
		return level;
	}

}
