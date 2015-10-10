package management.leveldesign;

import management.LinePattern;

/** Static class that holds al the different patterns of the game. */
public abstract class PatternsHolder {
    /** Holds the different patterns of the game.<br/>
     * <b>Wanted Syntax:</b><br/>
     * <code>lineX , lineY , lineLength : s1X , s1Y , s1width ; s2 [...]</code>
     * */
    public static final LinePattern[] PATTERNS = new LinePattern[] {
	new LinePattern( 1, 40, new String[] {
	"0,0,8:", "2,4,18:8,1,3", "14,1,10:", "22,-3,8:", "24,3,14:","32,0,8:" }),
	new LinePattern( 2, 25, new String[] {
	"0,0,8:","8,-1,4:","8,4,14:5,1,2","19,0,6:" }),
	new LinePattern( 3, 25, new String[] {
	"0,0,6:","2,3,12:","8,-2,14:","14,4,12:","20,0,5:" })
	
	
	
    	};
}
