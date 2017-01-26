package fr.darkxell.luwal.mechanics;

import java.awt.Color;

import fr.darkxell.luwal.utility.AnimatedColor;

/**
 * Describes all the meta stuff in a level.<br/>
 * Basically stores all of the values of the levels, including colors, speed,
 * rotationspeed and more...<br/>
 * <br/>
 * Refer to each value documentation for more informations.
 */
public abstract class LevelMeta {

	/**
	 * The scrollspeed of the level. Determines how fast the level goes,
	 * simulating the player movement by the scrollspeed.<br/>
	 * <br/>
	 * <b>Default</b>: 0.1, the speed of the tutorial.<br/>
	 * <br/>
	 * <b>Ratio</b>: in blocks per frame. Game is running at 100UPS by default.
	 */
	protected double scrollspeed = 0.1d;
	/**
	 * The rotation speed of the line in the level. Determines how fast the line
	 * turns when playing.<br/>
	 * <br/>
	 * <b>Default</b>: 0.3, the speed of rotation in the menus.<br/>
	 * <br/>
	 * <b>Ratio</b>: in degrees per frame.
	 */
	protected double rotatespeed = 0.3d;
	/** The background color of the level. */
	protected AnimatedColor background = AnimatedColor.BACKGROUND_GREY_DARK;
	/** The line color in the level. */
	protected AnimatedColor line = AnimatedColor.BACKGROUND_GREY;
	/** The color of the blocks in the level. */
	protected AnimatedColor level = AnimatedColor.BACKGROUND_GREY_DARK;
	/**
	 * The color of the active player in the level. This represents the solid
	 * player object, used to calculate collisions.
	 */
	protected AnimatedColor player = AnimatedColor.LIGHT_GREY;
	/**
	 * The player's ghost color. Appears where the player is going to reappears
	 * after a holded ride. <br/>
	 * <br/>
	 * Note: should be close to the line color.
	 */
	protected AnimatedColor playerghost = AnimatedColor.GHOST_GREY;

	/**
	 * Returns a random pattern usable by a level following this levelmeta at
	 * the wanted player position.
	 */
	public abstract Chunk getRandomPattern(double playerposition);

	/**
	 * Update method called each time a level linked to it is updated. By
	 * default does nothing, can be overrided to provide more contros to
	 * extended levelmetas.
	 */
	protected void update() {

	}

	public double getScrollSpeed() {
		return scrollspeed;
	}

	public double getRotateSpeed() {
		return rotatespeed;
	}

	public Color getBackgroundColor() {
		return background.getCurrentColor();
	}

	public Color getLineColor() {
		return line.getCurrentColor();
	}

	public Color getLevelColor() {
		return level.getCurrentColor();
	}

	public Color getPlayerColor() {
		return player.getCurrentColor();
	}

	public Color getPlayerGhostColor() {
		return playerghost.getCurrentColor();
	}

}
