package fr.darkxell.luwal.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.utility.FinalValues;

public class GameFrame {

	private JPanel canvas;
	private JFrame frame;
	private BufferedImage content = null;

	private boolean isopaque = false;

	public GameFrame() {
		// configuring the frame
		this.frame = new JFrame(FinalValues.gamename + " : " + FinalValues.gameversion);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocation(0, 0);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setBackground(new Color(0, 0, 0, 0));
		// configuring the canvas
		this.canvas = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(content, 0, 0, getWidth(), getHeight(), null);
			}
		};
		canvas.setOpaque(false);
		canvas.setSize(frame.getWidth(), frame.getHeight());
		frame.add(canvas);
		frame.setVisible(true);
		// Adding listeners
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Launcher.gamestate.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Launcher.gamestate.keyPressed(e);
			}
		});
	}

	/**
	 * Sets the frame's canvas to the wanted image.<br/>
	 * Image will be stretched if not the right ratio.
	 */
	public void setImage(BufferedImage image) {
		if (isopaque != Launcher.gamestate.isopaque()) {
			if (Launcher.gamestate.isopaque()) {
				canvas.setOpaque(true);
				frame.setBackground(new Color(0, 0, 0, 255));
				isopaque = true;
			} else {
				canvas.setOpaque(false);
				frame.setBackground(new Color(0, 0, 0, 0));
				isopaque = false;
			}
		}
		if (content != image) {
			if (content != null)
				content.flush();
			content = image;
			canvas.repaint();
		}
	}

	/** Returns the frame height */
	public int getHeight() {
		return frame.getHeight();
	}

	/** Returns the frame width */
	public int getWidth() {
		return frame.getWidth();
	}

}