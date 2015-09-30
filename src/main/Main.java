package main;

import display.FullFrame;

/** Main launching class. */
public abstract class Main {

    /** Public pointer to the Fullframe object used to display the entire game. */
    public static FullFrame frame;

    /** Launching method. */
    public static void main(String[] args) {
	frame = new FullFrame();
    }
}
