package management;

public class Spike {

    /** The offset of the spike relatively to the line start. */
    private int offset;
    /**
     * Is true if the spike is on the line, false if the spike is upside down
     * under it.
     */
    private boolean side;

    /** Default Skike constructor */
    public Spike(int offset, boolean side) {
	this.offset = offset;
	this.side = side;
    }

    public boolean getSide() {
	return this.side;
    }

    public int getOffset() {
	return this.offset;
    }

}
