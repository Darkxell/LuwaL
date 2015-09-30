package display.states;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Main;
import management.line.DisplayLine;
import ressources.Palette;
import ressources.Res;
import display.CanvasStatesHolder;
import display.FullCanvasState;

public class MenuState implements FullCanvasState {

    @Override
    public void print(Graphics g) {
	DisplayLine.print(g);
	g.setFont(Res.MAIN_FONT_TALL);
	char[] text = "Line".toCharArray();
	FontMetrics metrics = g.getFontMetrics();
	int width = metrics.stringWidth("Line");
	g.setColor(Palette.LIGHT_GREY);
	g.drawChars(text, 0, text.length, (Main.frame.getWidth() / 2)
		- (width / 2), Main.frame.getHeight() / 2);
	g.setFont(Res.MAIN_FONT_SMALL);
	metrics = g.getFontMetrics();
	width = metrics.stringWidth("Press space");
	text = "Press space".toCharArray();
	g.drawChars(text, 0, text.length, (Main.frame.getWidth() / 2)
		- (width / 2), (int) (Main.frame.getHeight() / 1.1));
    }

    @Override
    public void update() {

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
	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    DisplayLine.prepareRotativeDash();
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELCHOOSERSTATE;
	}
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
	    System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}
