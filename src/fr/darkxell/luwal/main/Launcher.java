package fr.darkxell.luwal.main;

import fr.darkxell.luwal.display.GameFrame;
import fr.darkxell.luwal.gamestates.OpenningState;

/**
 * Launcher class for the LuwaL game.<br/>
 * <br/>
 * LuwaL is the followup of a project I did before, called "LINE". The goal here
 * is to make a simple but complete game with the concept I created for "LINE".
 */
public class Launcher {

	/** The frame displaying the game. */
	public static GameFrame gameframe;
	/**
	 * The current state of the game. Used to calculate game mechanics and what
	 * the frame should display.
	 */
	public static DState gamestate = new OpenningState();

	/** Main launching method. Launches the entire LuwaL project. */
	public static void main(String[] args) {
		
		gameframe = new GameFrame();
		
		@SuppressWarnings("unused")
		Updater up = new Updater();

	}

}
