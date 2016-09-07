package fr.darkxell.luwal.main;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public abstract class DState {

	/** updates this state to the next frame. */
	public abstract void update();

	/**
	 * Gets a bufferedImage representation of the state at the moment the method
	 * is called.
	 */
	public abstract BufferedImage getPrint();

	/**
	 * Called if this state is the current processed state and the user presses
	 * a key on his keyboard.
	 */
	public abstract void keyPressed(KeyEvent e);
	/**
	 * Called if this state is the current processed state and the user releases
	 * a key on his keyboard.
	 */
	public abstract void keyReleased(KeyEvent e);
	
	/**Returns true if this state should be opaque or not, at the moment of the call.*/
	public boolean isopaque(){
		return true;
	}

}
