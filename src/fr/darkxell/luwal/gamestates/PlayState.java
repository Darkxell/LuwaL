package fr.darkxell.luwal.gamestates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import fr.darkxell.luwal.main.DState;
import fr.darkxell.luwal.main.DisplayLine;
import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.utility.KeysConfig;
import fr.darkxell.luwal.utility.Palette;

/** The state where the player actually plays the game. */
public class PlayState extends DState {

	private Level level;

	/** Builds a new playable state using a level. */
	public PlayState(Level level) {
		this.level = level;
	}

	@Override
	public void update() {
		DisplayLine.update();
		level.update();
		if (level.killed) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new LevelSelectState();
		}
	}

	@Override
	public BufferedImage getPrint() {
		BufferedImage buffer = new BufferedImage(Launcher.gameframe.getWidth(), Launcher.gameframe.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		// Background and line display
		g2d.setColor(Palette.BACKGROUND_GREY_DARK);
		g2d.fillRect(0, 0, buffer.getWidth(), buffer.getWidth());
		DisplayLine.print(g2d);
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
			Launcher.gamestate = new LevelSelectState();
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
