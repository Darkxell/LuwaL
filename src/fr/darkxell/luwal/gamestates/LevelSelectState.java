package fr.darkxell.luwal.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import fr.darkxell.luwal.main.DState;
import fr.darkxell.luwal.main.DisplayLine;
import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.mechanics.levels.Beginning_l1;
import fr.darkxell.luwal.mechanics.levels.Testlevel;
import fr.darkxell.luwal.utility.ImgRessources;
import fr.darkxell.luwal.utility.KeysConfig;
import fr.darkxell.luwal.utility.Palette;

public class LevelSelectState extends DState {

	/** The index of level selected. Starts at one. */
	private int levelselected = 1;
	/** The level type selected. */
	private int leveltypeselected = 1;
	private static final int LEVELTYPE_TUTORIAL = 0;
	private static final int LEVELTYPE_CLASSIC = 1;
	private static final int LEVELTYPE_SET = 2;

	private int levelnameopacity = 0;
	private int leveldescopacity = 0;

	private int levelnameoffset = 0;
	private int levelnameoffsetcounter = 0;

	@Override
	public void update() {
		DisplayLine.update();
		if (levelnameopacity <= 250)
			levelnameopacity += 5;
		if (leveldescopacity <= 253)
			leveldescopacity += 2;

		float bumpduration = 100f;
		final float mulsize = 13f;
		if (levelnameoffsetcounter > bumpduration)
			levelnameoffsetcounter = 0;
		else
			++levelnameoffsetcounter;
		bumpduration = levelnameoffsetcounter * 6 / bumpduration;
		levelnameoffset = (int) ((-Math.pow((bumpduration / 2), 2) + (bumpduration * 1.5f)) * mulsize);

	}

	@Override
	public BufferedImage getPrint() {
		BufferedImage buffer = new BufferedImage(Launcher.gameframe.getWidth(), Launcher.gameframe.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		// Background and line
		g2d.setColor(Palette.BACKGROUND_GREY_DARK);
		g2d.fillRect(0, 0, buffer.getWidth(), buffer.getWidth());
		DisplayLine.print(g2d);
		// Levels
		g2d.setColor(Palette.LIGHT_GREY);
		g2d.setFont(Palette.sheeping_dogs_big);
		String leveldisplay = "";
		String levelname = "";
		String leveldescription = "";
		switch (leveltypeselected) {
		case LEVELTYPE_TUTORIAL:
			leveldisplay = "Tutorial";
			levelname = "Tutorial stage";
			leveldescription = "Train the basics";
			break;
		case LEVELTYPE_CLASSIC:
			leveldisplay = "Classic";
			switch (levelselected) {
			case 1:
				levelname = "The beginning";
				leveldescription = "You don't know what you're stepping into";
				break;
			case 2:
				levelname = "Reactor";
				leveldescription = "Lose your sanity";
				break;
			case 3:
				levelname = "Absolution";
				leveldescription = "Gateway to hell";
				break;
			case 4:
				levelname = "Hope";
				leveldescription = "Don't give up";
				break;
			case 5:
				levelname = "Determination";
				leveldescription = "Pushing the limits";
				break;
			case 6:
				levelname = "The line";
				leveldescription = "The light at the end of the tunnel";
				break;
			case 7:
				levelname = "Apocalypse";
				leveldescription = "Chaos and destruction";
				break;
			case 8:
				levelname = "The end";
				leveldescription = "The last stand";
				break;
			case 9:
				levelname = "Void";
				leveldescription = "They said it was impossible. They were wrong.";
				break;

			default:
				levelname = "unknown";
				leveldescription = "Seems like something strange happened";
				break;
			}
			break;
		case LEVELTYPE_SET:
			leveldisplay = "Set Stages";
			levelname = "Work in progress";
			leveldescription = "Still in developpement, come back later";
			break;

		}
		g2d.drawString(leveldisplay, buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(leveldisplay) / 2,
				buffer.getHeight() / 4);
		g2d.setColor(new Color(200, 200, 200, levelnameopacity));
		g2d.setFont(Palette.sheeping_dogs_medium);
		if (levelselected > 2)
			g2d.drawImage(ImgRessources.lock, buffer.getWidth() / 2 - 50, buffer.getHeight() / 3, 100, 100, null);
		g2d.drawString(levelname, buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(levelname) / 2,
				buffer.getHeight() / 1.7f - levelnameoffset);
		g2d.setColor(new Color(200, 200, 200, leveldescopacity));
		g2d.setFont(Palette.sheeping_dogs_tiny);
		g2d.drawString(leveldescription, buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(leveldescription) / 2,
				buffer.getHeight() / 1.5f);
		// back button
		g2d.setFont(Palette.sheeping_dogs_smaller);
		g2d.setColor(new Color(200, 200, 200, 100));
		g2d.drawString("<<< " + KeysConfig.getKeyName(KeysConfig.back), 20, 40);
		// end
		g2d.dispose();
		return buffer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeysConfig.back) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new MenuState(false);
		}
		// up and down gestion to change the level type
		if (e.getKeyCode() == KeysConfig.up) {
			if (leveltypeselected <= LEVELTYPE_TUTORIAL)
				leveltypeselected = LEVELTYPE_SET;
			else
				leveltypeselected--;
			levelselected = 1;
			levelnameopacity = 0;
			leveldescopacity = 0;
			DisplayLine.prepareRotativeDash();
		} else if (e.getKeyCode() == KeysConfig.down) {
			if (leveltypeselected >= LEVELTYPE_SET)
				leveltypeselected = LEVELTYPE_TUTORIAL;
			else
				leveltypeselected++;
			levelselected = 1;
			levelnameopacity = 0;
			leveldescopacity = 0;
			DisplayLine.prepareRotativeDash();
			// Change the level number.
		} else if (e.getKeyCode() == KeysConfig.left && leveltypeselected == LEVELTYPE_CLASSIC) {
			if (levelselected > 1) {
				levelselected--;
				levelnameopacity = 0;
				leveldescopacity = 0;
				DisplayLine.prepareRotativeDash();
			}
		} else if (e.getKeyCode() == KeysConfig.right) {
			if (levelselected < 9 && leveltypeselected == LEVELTYPE_CLASSIC) {
				levelselected++;
				levelnameopacity = 0;
				leveldescopacity = 0;
				DisplayLine.prepareRotativeDash();
			}
		}
		// open the levels if the player has pressed enter.
		if (e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2) {
			if (levelselected == 1 && leveltypeselected == LEVELTYPE_TUTORIAL) {
				DisplayLine.prepareRotativeDash();
				Launcher.gamestate = new PlayState(new Testlevel());
			} else if (levelselected == 1 && leveltypeselected == LEVELTYPE_CLASSIC) {
				DisplayLine.prepareRotativeDash();
				Launcher.gamestate = new PlayState(new Beginning_l1());
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
