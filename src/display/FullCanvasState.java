package display;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface FullCanvasState {

    /** Takes a graphic object and draw the state on it. */
    public void print(Graphics g);

    /** Updates the attributes to get the next ones. */
    public void update();

    public void mouseReleased(MouseEvent e);

    public void mousePressed(MouseEvent e);

    public void mouseClicked(MouseEvent e);

    public void mouseMoved(MouseEvent e);

    public void mouseDragged(MouseEvent e);

    public void keyReleased(KeyEvent e);

    public void keyTyped(KeyEvent e);

    public void keyPressed(KeyEvent e);

}
