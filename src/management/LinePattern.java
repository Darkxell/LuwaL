package management;

public class LinePattern {

    /** The length of the pattern. */
    private int length;
    /** The lines inside the pattern. */
    private Line[] lines;
    /** The pattern id in the pattern list. */
    private int id;

    /** Creates a Pattern using the code of the lines. */
    public LinePattern(int id, int length, String[] lines) {
	this.length = length;
	this.id = id;
	Line[] content = new Line[lines.length];
	for (int i = 0; i < content.length; i++)
	    content[i] = new Line(lines[i]);
	this.lines = content;
    }

    /** Gets the length of the pattern. */
    public int getLength() {
	return this.length;
    }

    /**
     * Gets the <code>Line</code> array of the pattern. Keep in mind that the
     * lines positions are relative to the pattern and not to the level.
     */
    public Line[] getLines() {
	return this.lines;
    }

    /**
     * Gets the <code>ID</code> of the pattern.
     */
    public int getID() {
	return this.id;
    }

}
