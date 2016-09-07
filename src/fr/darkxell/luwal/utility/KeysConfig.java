package fr.darkxell.luwal.utility;

import java.awt.event.KeyEvent;

public class KeysConfig {

	public static int enter = KeyEvent.VK_ENTER;
	public static int enter2 = KeyEvent.VK_SPACE;
	public static int back = KeyEvent.VK_ESCAPE;

	public static int right = KeyEvent.VK_RIGHT;
	public static int left = KeyEvent.VK_LEFT;
	public static int up = KeyEvent.VK_UP;
	public static int down = KeyEvent.VK_DOWN;

	public static String getKeyName(int keyid) {
		switch (keyid) {
		case KeyEvent.VK_ENTER:
			return "enter";
		case KeyEvent.VK_TAB:
			return "tab";
		case KeyEvent.VK_SPACE:
			return "space";
		case KeyEvent.VK_ESCAPE:
			return "escape";
		default:
			return KeyEvent.getKeyText(keyid);
		}
	}
}
