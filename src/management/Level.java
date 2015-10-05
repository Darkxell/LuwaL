package management;

import utils.ArrayUtil;

public class Level {

    /**
     * The lines of the actual level. A line object contains a line and the
     * spikes on it.
     */
    private Line[] lines;

    /** Creates a Level using its String encoded version. */
    public Level(String code) {
	// TODO : Level Codes decoder.
    }

    /** Creates a random level using an array of patterns. */
    public Level(LinePattern[] p) {
	Line[] lines = new Line[] {new Line(-40,0,40)};
	int offset = 0;
	while (offset < 10000) {
	    LinePattern toadd = p[(int) (Math.random() * (p.length))];
	    for (int i = 0; i < toadd.getLines().length; i++)
		lines = ArrayUtil.addLineToArray(lines,
			toadd.getLines()[i].cloneToOffset(offset));
	    offset += toadd.getLength();
	}
	this.lines = lines;
    }

    /** Gets the number of lines */
    public int getLinesAmmount() {
	return lines.length;
    }

    /** Gets the wanted line in the level. */
    public Line getLine(int index) {
	return lines[index];
    }

}
