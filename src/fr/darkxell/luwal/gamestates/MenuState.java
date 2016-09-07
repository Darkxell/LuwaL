package fr.darkxell.luwal.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import fr.darkxell.luwal.main.DState;
import fr.darkxell.luwal.main.DisplayLine;
import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.utility.FinalValues;
import fr.darkxell.luwal.utility.KeysConfig;
import fr.darkxell.luwal.utility.Palette;

public class MenuState extends DState {

	public MenuState() {
	}

	public MenuState(boolean textgoesup) {
		this.textgoesup = textgoesup;
	}

	private boolean textgoesup = true;
	private int titleheight = 1;
	private boolean goback = false;

	private int choice = 0;
	private static final int CHOICE_PLAY = 0;
	@SuppressWarnings("unused")
	private static final int CHOICE_TUTORIAL = 1;
	@SuppressWarnings("unused")
	private static final int CHOICE_OPTIONS = 2;
	private static final int CHOICE_CREDITS = 3;
	private int arrowheight;

	private int selectarrowoffset = 0;
	private int arrowoffsetcounter = 0;

	@Override
	public void update() {
		DisplayLine.update();
		if (titleheight == 25)
			textgoesup = true;
		if (titleheight < 25 && !goback)
			++titleheight;
		if (titleheight > 0 && goback)
			--titleheight;
		if (titleheight == 0)
			Launcher.gamestate = new OpenningState(405);
		int wantedheight = 80 * choice;
		if (arrowheight > wantedheight)
			arrowheight -= 8;
		if (arrowheight < wantedheight)
			arrowheight += 8;

		// selectarrowoffset equation : y = -((x/2)^2)+(1.5*x)
		float bumpduration = 100f;
		final float mulsize = 13f;
		if (arrowoffsetcounter > bumpduration)
			arrowoffsetcounter = 0;
		else
			++arrowoffsetcounter;
		bumpduration = arrowoffsetcounter * 6 / bumpduration;
		selectarrowoffset = (int) ((-Math.pow((bumpduration / 2), 2) + (bumpduration * 1.5f)) * mulsize);

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
		// Game name
		g2d.setFont(Palette.sheeping_dogs_big);
		g2d.setColor(Palette.LIGHT_GREY);
		int additionalheight = textgoesup ? buffer.getHeight() / 100 * titleheight : buffer.getHeight() / 100 * 25;
		g2d.drawString(FinalValues.gamename,
				buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(FinalValues.gamename) / 2,
				buffer.getHeight() / 2 - additionalheight);
		// Menu options
		g2d.setColor(new Color(200, 200, 200, 10 * titleheight));
		g2d.setFont(Palette.sheeping_dogs_small);
		int baseheight = buffer.getHeight() / 2;
		g2d.drawString("Play", buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth("Play") / 2, baseheight);
		g2d.drawString("Tutorial", buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth("Tutorial") / 2,
				baseheight + 80);
		g2d.drawString("Options", buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth("Options") / 2,
				baseheight + 160);
		g2d.drawString("Credits", buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth("Credits") / 2,
				baseheight + 240);
		// Display arrows
		g2d.drawString(">", buffer.getWidth() / 2 - 200 - selectarrowoffset, baseheight + arrowheight);
		g2d.drawString("<", buffer.getWidth() / 2 + 180 + selectarrowoffset, baseheight + arrowheight);
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
		if (e.getKeyCode() == KeysConfig.back)
			goback = true;
		if (e.getKeyCode() == KeysConfig.down) {
			if (choice >= CHOICE_CREDITS)
				choice = CHOICE_PLAY;
			else
				++choice;
		}
		if (e.getKeyCode() == KeysConfig.up) {
			if (choice <= CHOICE_PLAY)
				choice = CHOICE_CREDITS;
			else
				--choice;
		}
		if ((e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2) && choice == CHOICE_PLAY) {
			DisplayLine.prepareRotativeDash();
			Launcher.gamestate = new LevelSelectState();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
