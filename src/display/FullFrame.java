package display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/** A fullscreen frame. Contains a canvas used to display the actual game. */
public class FullFrame {

    private int height;
    private int width;
    private JFrame frame;
    private FullCanvas canvas;
    private Thread canvasupdater;

    /** Constructs a FullFrame object and display it to the user. */
    public FullFrame() {
	this.frame = new JFrame("Line");
	this.frame.setUndecorated(true);
	this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.canvas = new FullCanvas();
	this.canvas.state = CanvasStatesHolder.MENUSTATE;
	this.frame.add(this.canvas);
	this.canvasupdater = new Thread(this.canvas);
	this.canvasupdater.start();
	this.canvas.addMouseListener(new MouseListener() {

	    public void mouseReleased(MouseEvent e) {
		canvas.state.mouseReleased(e);
	    }

	    public void mousePressed(MouseEvent e) {
		canvas.state.mousePressed(e);
	    }

	    public void mouseExited(MouseEvent e) {
	    }

	    public void mouseEntered(MouseEvent e) {
	    }

	    public void mouseClicked(MouseEvent e) {
		canvas.state.mouseClicked(e);
	    }
	});
	this.canvas.addMouseMotionListener(new MouseMotionListener() {

	    public void mouseMoved(MouseEvent e) {
		canvas.state.mouseMoved(e);
	    }

	    public void mouseDragged(MouseEvent e) {
		canvas.state.mouseDragged(e);
	    }
	});
	this.canvas.addKeyListener(new KeyListener() {

	    public void keyTyped(KeyEvent e) {
		canvas.state.keyTyped(e);
	    }

	    public void keyReleased(KeyEvent e) {
		canvas.state.keyReleased(e);
	    }

	    public void keyPressed(KeyEvent e) {
		canvas.state.keyPressed(e);
	    }
	});
	// Sets the frame to visible
	this.frame.setVisible(true);
	this.height = this.frame.getHeight();
	this.width = this.frame.getWidth();
	this.canvas.createBufferStrategy(3);
    }

    public int getHeight() {
	return this.height;
    }

    public int getWidth() {
	return this.width;
    }

    /**
     * Grants access to the inner JFrame object. Should not be used.
     * 
     * @deprecated
     * */
    public JFrame getFrame() {
	return this.frame;
    }

    /** Returns the canvas Object used in the frame. */
    public FullCanvas getFullCanvas() {
	return this.canvas;
    }

}
