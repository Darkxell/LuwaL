package management;

import utils.SpikeUtility;

public class Line {

    /** The horisontal offset of the line start in the level. */
    private int posX;
    /** The vertical offset of the whole line relatively to the middle. */
    private int posY;
    /** The length of the line. */
    private int length;
    /** The spikes on the line */
    private Spike[] spikes;

    /**
     * Default Line constructor. The created line has a <code>null</code> spike
     * array.
     */
    public Line(int x, int y, int length) {
	this.length = length;
	this.posX = x;
	this.posY = y;
    }

    /**
     * <code>posX,posY,length:SPIKECODE</code><br/>
     * Creates a Line object using the previously displayed String pattern.
     */
    public Line(String lineCode) {
	String[] uncoded = lineCode.split(":");

	String[] args = uncoded[0].split(",");
	this.posX = Integer.parseInt(args[0]);
	this.posY = Integer.parseInt(args[1]);
	this.length = Integer.parseInt(args[2]);
	try {
	    this.spikes = SpikeUtility.createSpikeArray(uncoded[1]);
	} catch (Exception e) {
	}
    }

    public Line(int x, int y, int length, Spike[] spikes) {
	this(x, y, length);
	this.spikes = spikes;
    }

    /**
     * Gets the raw spikes array of the lines. The returned spikes array is
     * relative to the line display position.
     */
    public Spike[] getSpikes() {
	return spikes;
    }

    public int getX() {
	return posX;
    }

    public int getY() {
	return posY;
    }

    public int getLength() {
	return length;
    }

    public Line cloneToOffset(int offset) {
	return new Line(this.posX + offset, this.posY, this.length, this.spikes);
    }

}
