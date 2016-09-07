package fr.darkxell.luwal.utility;

import java.util.LinkedList;

/**
 * An utility object that can be used to store how many times per second we call
 * it's update method.
 * 
 * @author AdventurerOK
 */
public class FPSmeter {

	private static final long ONE_SECOND = 1000000000L;

	/** List of frames within 1 second. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	LinkedList<Long> frames = new LinkedList();

	/**
	 * Returns how many times this method has been called in the last second.
	 */
	public int calcFPS() {
		long time = System.nanoTime();
		frames.add(time); // Add this frame to the list
		for (;;) {
			long f = frames.getFirst(); // Look at the first element in frames
			if (time - f > ONE_SECOND) { // If it was more than 1 second ago
				frames.remove(); // Remove it from the list of frames
			} else
				break;
			/*
			 * If it was within 1 second we know that all other frames in the
			 * list are also within 1 second
			 */
		}
		return frames.size(); // Return the size of the list
	}
}
