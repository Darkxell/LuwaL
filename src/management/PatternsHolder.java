package management;

/** Static class that holds al the different patterns of the game. */
public abstract class PatternsHolder {
    // Pattern syntax :
    // lineX , lineY , lineLength : s1X , s1Y , s1width ; s2 [...]
    public static final LinePattern[] PATTERNS = new LinePattern[] {
	new LinePattern( 40, new String[] {
	"0,0,8:", "2,4,18:11,1,1", "14,1,10:", "22,-3,8:", "24,3,14:","32,0,8:" }) 
	
	
	
	
    	};
}
