package fr.darkxell.luwal.mechanics;

import java.awt.Graphics2D;

public class Player {

	/** The level the player is inside right now. */
	private Level level;

	/**
	 * Builds a new player at the default position, ideal for a player in a
	 * brand new level.
	 */
	public Player(Level level) {
		this.level = level;
	}

	public final boolean GRAVITY_NORMAL = false;
	public final boolean GRAVITY_REVERSE = true;
	/** the x position of the player in the level. */
	private double x = 0d;
	/** the y position of the player in the level. */
	private double y = 0d;
	/**
	 * The gravity state of the player. Equals GRAVITY_NORMAL or
	 * GRAVITY_REVERSE.
	 */
	private boolean gravity = GRAVITY_NORMAL;
	/**
	 * The if the player is sliding, appearing 'below' the bridge he is
	 * currently riding.
	 */
	public boolean isSliding = false;

	/** Updates this player. */
	public void update() {
		x += level.meta.scrollspeed;
		gravityTick();
		if (y < -2 || y > level.height + 2)
			level.killed = true;
		else if (level.getBlockAt((int) x, (int) getEffectiveY()) == Block.BLOCK_SOLID) {
			level.killed = true;
		}
	}

	/** Triggers the player gravity to make him move once. */
	private void gravityTick() {
		for (int i = 0; i < level.height + 2; i++)
			if (gravity == GRAVITY_NORMAL) {
				if (level.getBlockAt((int) x, (int) y + 1) != Block.BLOCK_SOLID)
					y += 1;
			} else {
				if (level.getBlockAt((int) x, (int) y - 1) != Block.BLOCK_SOLID)
					y -= 1;
			}
	}

	public void draw(Graphics2D g2d) {
		// unused?
	}

	public boolean getGravity() {
		return gravity;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEffectiveY() {
		if (!isSliding)
			return y;
		if (gravity == GRAVITY_NORMAL)
			return y + 2;
		else
			return y - 2;
	}

	/** Called when the user presses the screen. */
	public void press() {
		if (!isSliding) {
			this.gravity = !this.gravity;
			this.isSliding = true;
		}

	}

	/** Called when the user releases the screen. */
	public void release() {
		this.isSliding = false;
	}

}
