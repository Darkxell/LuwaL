package fr.darkxell.luwal.gamestates;

import java.awt.AlphaComposite;
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

public class OpenningState extends DState {

	public OpenningState() {
	}

	public OpenningState(int progress) {
		this.counter = progress;
	}

	private int exitmode = 0;

	private int textflicker = 0;

	private int counter = 0;

	@Override
	public void update() {
		++counter;
		if (counter > 305) {
			textflicker++;
			DisplayLine.update();
		}
		if (exitmode >= 50)
			System.exit(0);

		if (textflicker >= 254)
			textflicker = -255;

	}

	public boolean isopaque() {
		return counter > 305 && exitmode == 0;
	}

	@Override
	public BufferedImage getPrint() {
		BufferedImage buffer = new BufferedImage(Launcher.gameframe.getWidth(), Launcher.gameframe.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);

		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		// Waits 50 frames
		if (counter < 50)
			return buffer;
		// Gradient to gray fullscreen
		int height = (counter * counter / 300 - 50) > buffer.getHeight() ? buffer.getHeight()
				: (counter * counter / 300 - 50) * buffer.getHeight() / 255;
		g2d.setColor(new Color(100, 100, 100, counter > 305 ? 255 : counter - 50));
		g2d.fillRect(0, (buffer.getHeight() - height) / 2, buffer.getWidth(), height);
		// Makes the line appears
		if (counter > 305) {
			DisplayLine.print(g2d);
			// Gametitle
			g2d.setFont(Palette.sheeping_dogs_big);
			int titleopacity = (counter - 300) * 3;
			g2d.setColor(new Color(200, 200, 200, titleopacity > 255 ? 255 : titleopacity));
			g2d.drawString(FinalValues.gamename,
					buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(FinalValues.gamename) / 2,
					buffer.getHeight() / 2);
			// back button
			g2d.setFont(Palette.sheeping_dogs_smaller);
			g2d.setColor(new Color(200, 200, 200, 100));
			g2d.drawString("<<< " + KeysConfig.getKeyName(KeysConfig.back), 20, 40);
			// Press enter text
			g2d.setFont(Palette.sheeping_dogs_small);
			g2d.setColor(new Color(200, 200, 200, Math.abs(textflicker)));
			String flickertext = "Press " + KeysConfig.getKeyName(KeysConfig.enter);
			g2d.drawString(flickertext, buffer.getWidth() / 2 - g2d.getFontMetrics().stringWidth(flickertext) / 2,
					buffer.getHeight() / 1.3f);
		}

		if (exitmode > 0) {
			BufferedImage img = new BufferedImage(buffer.getWidth(), buffer.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g = (Graphics2D) img.getGraphics();
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					1 - (float) (exitmode) / 50 > 0f ? 1 - (float) (exitmode) / 50 : 0f));
			g.drawImage(buffer, 0, 0, buffer.getWidth(), buffer.getHeight(), null);
			g.dispose();
			exitmode++;
			return img;
		}
		g2d.dispose();
		return buffer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeysConfig.back && exitmode == 0 && counter > 305) {
			exitmode = 1;
		}
		if ((e.getKeyCode() == KeysConfig.enter || e.getKeyCode() == KeysConfig.enter2) && counter > 305) {
			Launcher.gamestate = new MenuState();
			DisplayLine.prepareRotativeDash();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
