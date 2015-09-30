package display;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import management.line.DisplayLine;

public class FullCanvas extends Canvas implements Runnable {

    /** The actual state of the canvas. */
    public FullCanvasState state;

    private static final long serialVersionUID = 1L;

    /**
     * Updates the canvas to match the state. Creates a buffer and prints the
     * state print method on it, then displays the buffer.
     */
    @Override
    public void update(Graphics g) {
	BufferStrategy bs = this.getBufferStrategy();
	Graphics gr = bs.getDrawGraphics();
	this.state.print(gr);
	bs.show();
	gr.dispose();
    }

    /** Run method of the canvas. Updates it about 50 times a second. */
    @Override
    public void run() {
	long milistart = System.currentTimeMillis();
	int frame  = 0;
	for (;;) {
	    while(milistart +(frame*20)>System.currentTimeMillis()){
		try {
		Thread.sleep(2);
	    } catch (InterruptedException e) {
	    }
	    }
	    ++frame;
	    try {
		this.update(null);
	    } catch (Exception e) {
	    }
	    try {
		this.state.update();
	    } catch (Exception e) {
	    }
	    try {
		DisplayLine.update();
	    } catch (Exception e) {
	    }

	}

    }

}
