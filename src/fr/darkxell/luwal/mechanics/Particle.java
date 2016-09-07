package fr.darkxell.luwal.mechanics;

import java.awt.Graphics2D;

public abstract class Particle {

	/** The x position of the particle in the level. */
	protected int x;
	/** The Y position of the particle in the level. */
	protected int y;

	/** Updates this particle. */
	public abstract void update();

	/** Prints this particle using the specified graphics context. */
	public abstract void print(Graphics2D g2d);

}
