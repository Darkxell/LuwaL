package management;

public class Line {

    /** The horisontal offset of the line start in the level. */
    private int posX;
    /** The vertical offset of the whole line relatively to the middle. */
    private int posY;
    /** The length of the line. */
    private int length;
    /** The spikes on the line */
    private Spike[] spikes;

    public Line(int x, int y, int length) {
	this.length = length;
	this.posX = x;
	this.posY = y;
    }

    /**
     * <code>posX,posY,length</code><br/>
     * Creates a Line object using the previously displayed String pattern.
     */
    public Line(String lineCode) {
	String[] args = lineCode.split(",");
	this.posX = Integer.parseInt(args[0]);
	this.posY = Integer.parseInt(args[1]);
	this.length = Integer.parseInt(args[2]);
    }

    public Line(int x, int y, int length, Spike[] spikes) {
	this(x, y, length);
	this.spikes = spikes;
    }

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
