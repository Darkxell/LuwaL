package display.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Main;
import management.line.CurrentLevelHolder;
import management.line.DisplayLine;
import display.CanvasStatesHolder;
import display.FullCanvasState;

public class LevelState implements FullCanvasState {

    @Override
    public void print(Graphics g) {
	DisplayLine.print(g);
	
    }

    @Override
    public void update() {
	CurrentLevelHolder.playerX += 0.3;
	CurrentLevelHolder.time += 0.02;
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
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	    DisplayLine.prepareRotativeDash();
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.MENUSTATE;
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}
