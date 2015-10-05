package display.states;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import ressources.Res;
import main.Main;
import management.Level;
import management.PatternsHolder;
import management.line.CurrentLevelHolder;
import management.line.DisplayLine;
import display.CanvasStatesHolder;
import display.FullCanvasState;

public class LevelEndState implements FullCanvasState {

    /** The pannel offset to the right. */
    public int panneloffset = 0;

    @Override
    public void print(Graphics g) {
	DisplayLine.print(g);
	int offset = (panneloffset * Main.frame.getWidth() / 40);
	g.setColor(CurrentLevelHolder.BackgroundColor);
	g.fillRect((2 * Main.frame.getWidth() / 3) + offset, 0,
		Main.frame.getWidth() / 3, Main.frame.getHeight());
	g.fillPolygon(
		new int[] { (2 * Main.frame.getWidth() / 3) + offset,
			(2 * Main.frame.getWidth() / 3) + offset,
			(Main.frame.getWidth() / 3) + offset }, new int[] { 0,
			Main.frame.getHeight(), Main.frame.getHeight() }, 3);
	g.setColor(CurrentLevelHolder.LineColor);
	g.fillPolygon(
		new int[] { (2 * Main.frame.getWidth() / 3) + offset,
			(2 * Main.frame.getWidth() / 3) + offset + 30,
			(Main.frame.getWidth() / 3) + offset + 30,
			(Main.frame.getWidth() / 3) + offset }, new int[] { 0,
			0, Main.frame.getHeight(), Main.frame.getHeight() }, 4);
	g.setFont(Res.MAIN_FONT_NORMAL);
	g.setColor(CurrentLevelHolder.LevelFontColor);
	char[] text;
	FontMetrics metrics = g.getFontMetrics();
	int width = metrics.stringWidth("Game Over");
	text = "GameOver".toCharArray();
	int xposition = (5 * Main.frame.getWidth() / 6) - (width / 2);
	g.drawChars(text, 0, text.length, (2 * Main.frame.getWidth() / 3)
		- (width / 2) + offset, (int) (Main.frame.getHeight() / 1.1));
	text = ("" + ((float) ((int) (CurrentLevelHolder.time * 100))) / 100)
		.toCharArray();
	g.drawChars(text, 0, text.length, xposition,
		(int) (Main.frame.getHeight() / 3));
	text = ("Run Time".toCharArray());
	g.drawChars(text, 0, text.length, xposition,
		(int) (Main.frame.getHeight() / 4));
    }

    @Override
    public void update() {
	if (panneloffset > 0)
	    panneloffset--;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_SPACE && panneloffset == 0) {
	    DisplayLine.prepareRotativeDash();
	    CurrentLevelHolder.time = 0;
	    CurrentLevelHolder.playerX = 0;
	    CurrentLevelHolder.playerY = 1;
	    CurrentLevelHolder.playerSide = false;
	    CurrentLevelHolder.isSliding = false;
	    CurrentLevelHolder.currentLevel = new Level(PatternsHolder.PATTERNS);
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELSTATE;
	} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE && panneloffset == 0) {
	    CurrentLevelHolder.time = 0;
	    DisplayLine.prepareRotativeDash();
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELCHOOSERSTATE;
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}
