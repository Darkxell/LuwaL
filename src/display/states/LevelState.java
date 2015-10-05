package display.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import ressources.Res;
import main.Main;
import management.Line;
import management.line.CurrentLevelHolder;
import management.line.DisplayLine;
import display.CanvasStatesHolder;
import display.FullCanvasState;

public class LevelState implements FullCanvasState {

    @Override
    public void print(Graphics g) {
	DisplayLine.print(g);
	g.setColor(CurrentLevelHolder.LevelFontColor);
	g.setFont(Res.MAIN_FONT_NORMAL);
	char[] text = ("" + ((float) ((int) (CurrentLevelHolder.time * 100))) / 100)
		.toCharArray();
	g.drawChars(text, 0, text.length, 15, 60);
    }

    @Override
    public void update() {
	CurrentLevelHolder.playerX += CurrentLevelHolder.scrollspeed;
	CurrentLevelHolder.time += 0.02;
	while (!isOnFloor() && isPlayerInBounds()) {
	    if (CurrentLevelHolder.playerSide) {
		++CurrentLevelHolder.playerY;
	    } else {
		--CurrentLevelHolder.playerY;
	    }
	}
	if (!isPlayerInBounds() || isPlayerOnSpike()) {
	    CanvasStatesHolder.LEVELENDSTATE.panneloffset = 20;
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELENDSTATE;
	}

    }

    /** Returns true if the player is on spikes at the moment. */
    private boolean isPlayerOnSpike() {
	// TODO
	return false;
    }

    private boolean isPlayerInBounds() {
	return CurrentLevelHolder.playerY > -10
		&& CurrentLevelHolder.playerY < 10;
    }

    /** Returns true if the player is on a platform at the moment. */
    private boolean isOnFloor() {
	for (int i = 0; i < CurrentLevelHolder.currentLevel.getLinesAmmount(); i++) {
	    Line l = CurrentLevelHolder.currentLevel.getLine(i);
	    if (CurrentLevelHolder.playerX >= l.getX()
		    && CurrentLevelHolder.playerX <= l.getX() + l.getLength()
		    && (CurrentLevelHolder.playerSide ? ((int) CurrentLevelHolder.playerY) + 1 == l
			    .getY()
			    : ((int) CurrentLevelHolder.playerY) - 1 == l
				    .getY())) {
		return true;
	    }
	}
	return false;
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
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELENDSTATE;
	    CanvasStatesHolder.LEVELENDSTATE.panneloffset = 20;
	} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    CurrentLevelHolder.isSliding = false;
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_SPACE && !CurrentLevelHolder.isSliding) {
	    CurrentLevelHolder.isSliding = true;
	    CurrentLevelHolder.playerSide = !CurrentLevelHolder.playerSide;
	}
    }

}
