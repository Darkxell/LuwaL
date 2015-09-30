package utils;

/** Abstract class holding utility methods to manipulate Stings. */
public abstract class StringUtility {

    /**
     * Static method to get the content of a bracket occurence in a String. May
     * return white spaces at the begining or at the end, keep that in mind.
     */
    public static String getBracketsContent(String line, int bracketOccurence,
	    char openbracket, char closebracket) {
	char[] chararray = line.toCharArray();
	int counter = 0, i = 0;
	try {
	    while (counter != bracketOccurence) {
		if (chararray[i] == openbracket)
		    counter++;
		i++;
	    }
	} catch (Exception e) {
	}
	counter = 0;
	String toReturn = "";
	while (counter != 0 || chararray[i] != closebracket) {
	    if (chararray[i] == openbracket)
		counter++;
	    if (chararray[i] == closebracket)
		counter--;
	    toReturn += chararray[i];
	    i++;
	}
	return toReturn;
    }

    /**
     * Returns the same string without blank spaces at the begining nor the end.
     */
    public static String getAbsoluteContent(String text) {
	char[] chararray = text.toCharArray();
	char[] temp;
	while (chararray[0] == ' ') {
	    temp = new char[chararray.length - 1];
	    for (int i = 0; i < temp.length; i++)
		temp[i] = chararray[i + 1];
	    chararray = temp;
	}
	while (chararray[chararray.length - 1] == ' ') {
	    temp = new char[chararray.length - 1];
	    for (int i = 0; i < temp.length; i++)
		temp[i] = chararray[i];
	    chararray = temp;
	}
	String toReturn = "";
	for (int i = 0; i < chararray.length; i++)
	    toReturn += chararray[i];
	return toReturn;
    }

}
