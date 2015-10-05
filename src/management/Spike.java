package management;

public class Spike {

    /** The offset of the spike relatively to the line start. */
    private double offset;
    /**
     * Is <code>true</code> if the spike is on the line, <code>false</code> if
     * the spike is upside down under it.
     */
    private boolean side;
    /** The spike size (width). */
    private double spikewidth = 1.0d;

    /**
     * Default Skike constructor. The default spike width equals
     * <code>1.0d</code>.
     * 
     * @deprecated : Pretty much useless.
     */
    public Spike(double offset, boolean side) {
	this.offset = offset;
	this.side = side;
    }

    /** Default Skike constructor with additionnal spike width. */
    public Spike(double offset, boolean side, double spikewidth) {
	this(offset, side);
	this.spikewidth = spikewidth;

    }

    public boolean getSide() {
	return this.side;
    }

    public double getOffset() {
	return this.offset;
    }

    public double getWidth() {
	return this.spikewidth;
    }

}
