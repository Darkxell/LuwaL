package fr.darkxell.luwal.mechanics;

import java.awt.Color;

import fr.darkxell.luwal.utility.Palette;

public abstract class LevelMeta {

	protected double scrollspeed = 0.1d;
	protected double rotatespeed = 0.3d;
	protected Color background = Palette.BACKGROUND_GREY_DARK;
	protected Color line = Palette.BACKGROUND_GREY;
	protected Color level = Palette.BACKGROUND_GREY_DARK;
	protected Color player = Palette.LIGHT_GREY;
	protected Color playerghost = Palette.GHOST_GREY;

	/**
	 * Returns a random pattern usable by a level following this levelmeta at
	 * the wanted player position.
	 */
	public abstract Chunk getRandomPattern(double playerposition);

	public double getScrollSpeed() {
		return scrollspeed;
	}

	public double getRotateSpeed() {
		return rotatespeed;
	}

	public Color getBackgroundColor() {
		return background;
	}

	public Color getLineColor() {
		return line;
	}

	public Color getLevelColor() {
		return level;
	}

	public Color getPlayerColor() {
		return player;
	}

	public Color getPlayerGhostColor() {
		return playerghost;
	}
}
