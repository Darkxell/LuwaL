package fr.darkxell.luwal.main;

import fr.darkxell.luwal.utility.AnimatedColor;
import fr.darkxell.luwal.utility.FPSmeter;
import fr.darkxell.luwal.utility.FinalValues;

public class Updater {

	private static final boolean SHOWFPS = false;
	private static final boolean capfps = false;
	private FPSmeter meter = new FPSmeter();
	private Thread render;
	private Thread update;
	private long updatestarttime;

	public Updater() {
		// Rendering thread
		render = new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {
					Launcher.gameframe.setImage(Launcher.gamestate.getPrint());
					if(SHOWFPS)
						System.out.println("FPS : " + meter.calcFPS());
					if (capfps)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							System.err.println("WARNING : renderer thread could not sleep for unknown reasons.");
						}
				}
			}
		});
		render.start();
		// Updater thread
		update = new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {
					updatestarttime = System.currentTimeMillis();
					Launcher.gamestate.update();
					AnimatedColor.updateAllColors();
					while (System.currentTimeMillis() < updatestarttime + (1000 / FinalValues.UPS)) {
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							System.err.println("WARNING : updater thread could not sleep for unknown reasons.");
						}
					}
				}
			}
		});
		update.start();

	}

}
