package utils;

import management.Line;

public class ArrayUtil {

    public static Line[] addLineToArray(Line[] array, Line toadd) {
	Line[] array2 = new Line[array.length + 1];
	System.arraycopy(array, 0, array2, 0, array.length);
	array2[array.length] = toadd;
	return array2;
    }

    /** Returns true if the array includes the value. */
    public static boolean arrayInclude(int[] array, int value) {
	for (int i = 0; i < array.length; i++)
	    if (array[i] == value)
		return true;
	return false;
    }
}