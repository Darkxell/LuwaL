package utils;

import management.Spike;

/**
 * Static class that holds a method to construct spikes arrays relatives to
 * lines.
 */
public abstract class SpikeUtility {

    /**
     * Creates a spike array using it's creator code.<br/>
     * Creator code should have the following syntax :<br/>
     * <code>s1X , s1Y , s1Width ; [...] ; snX , snY , snWidth </code>
     */
    public static Spike[] createSpikeArray(String creatorCode) {
	String[] script = creatorCode.split(";");

	Spike[] toreturn = new Spike[script.length];
	for (int i = 0; i < toreturn.length; i++) {
	    String[] args = script[i].split(",");
	    toreturn[i] = new Spike(Double.parseDouble(args[0]),
		    Integer.parseInt(args[1]) == 1, Double.parseDouble(args[2]));
	}

	return toreturn;
    }

}
