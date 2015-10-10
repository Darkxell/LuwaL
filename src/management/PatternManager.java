package management;

import management.leveldesign.PatternsHolder;
import utils.ArrayUtil;

/** Static class that holds different method to manage the patterns. */
public abstract class PatternManager {

    /**
     * Returns an array of patterns according to the pattrens in in parametters.
     * IF the wanted ID is not found in the pattern list then it's replaced by a
     * 0 length pattern.
     */
    public static LinePattern[] getPatternArrayFromIDs(int[] ids) {
	LinePattern[] toreturn = new LinePattern[ids.length];
	for (int i = 0; i < ids.length; i++) {
	    toreturn[i] = new LinePattern(0, 0, new String[] { "0,0,0:" });
	    for (int j = 0; j < PatternsHolder.PATTERNS.length; j++) {
		if (ArrayUtil.arrayInclude(ids,
			PatternsHolder.PATTERNS[j].getID())) {
		    toreturn[i] = PatternsHolder.PATTERNS[j];
		}
	    }
	}
	return toreturn;
    }

}
