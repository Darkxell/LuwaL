package fr.darkxell.luwal.utility;

import java.awt.Color;

/**
 * A way to store colors that change tone time passing by. Handles transparency.
 */
public enum AnimatedColor {

	BACKGROUND_GREY(150, 150, 150, 255),
	BACKGROUND_GREY_DARK(100, 100, 100, 255),
	LIGHT_GREY(200, 200, 200, 255),
	GHOST_GREY(165, 165, 165, 255),
	BEGINNING_BACKGROUND(80,120, 65,85, 90,110, 255,255,0.1f),
	BEGINNING_LEVEL(100, 75, 100, 255),
	BEGINNING_LINE(150, 130, 150, 255),
	BEGINNING_PLAYER(200, 150, 200, 255),
	BEGINNING_GHOST(120, 90, 120, 255);

	/** Builds an animated color. */
	private AnimatedColor(int rMin, int rMax, int gMin, int gMax, int bMin, int bMax, int aMin, int aMax,
			float changingspeed) {
		this.isanimated = true;
		this.r = rMin;
		this.g = gMin;
		this.b = bMin;
		this.a = aMin;
		this.rMin = rMin;
		this.gMin = gMin;
		this.bMin = bMin;
		this.aMin = aMin;
		this.rMax = rMax;
		this.gMax = gMax;
		this.bMax = bMax;
		this.aMax = aMax;
		this.changingSpeed = changingspeed;
	}

	/** Builds a non animated color. */
	private AnimatedColor(int r, int g, int b, int a) {
		this.isanimated = false;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	private boolean isanimated;
	private float r;
	private float g;
	private float b;
	private float a;
	private float rMax;
	private float gMax;
	private float bMax;
	private float aMax;
	private float rMin;
	private float gMin;
	private float bMin;
	private float aMin;
	private boolean rIncreases = true;
	private boolean gIncreases = true;
	private boolean bIncreases = true;
	private boolean aIncreases = true;

	private float changingSpeed = 1;

	private void update() {
		if (isanimated) {
			// red
			if (rIncreases && r + changingSpeed > rMax)
				rIncreases = false;
			else if (!rIncreases && r - changingSpeed < rMin)
				rIncreases = true;
			else
				r += rIncreases ? changingSpeed : -changingSpeed;
			// green
			if (gIncreases && g + changingSpeed > gMax)
				gIncreases = false;
			else if (!gIncreases && g - changingSpeed < gMin)
				gIncreases = true;
			else
				g += gIncreases ? changingSpeed : -changingSpeed;
			// blue
			if (bIncreases && b + changingSpeed > bMax)
				bIncreases = false;
			else if (!bIncreases && b - changingSpeed < bMin)
				bIncreases = true;
			else
				b += bIncreases ? changingSpeed : -changingSpeed;
			// alpha
			if (aIncreases && a + changingSpeed > aMax)
				aIncreases = false;
			else if (!aIncreases && a - changingSpeed < aMin)
				aIncreases = true;
			else
				a += aIncreases ? changingSpeed : -changingSpeed;
		}
	}

	/**
	 * Returns a new Color object representing the color of this animated color
	 * object at the moment the method is invoked.
	 */
	public Color getCurrentColor() {
		return new Color(this.r / 255, this.g / 255, this.b / 255, this.a / 255);
	}

	public static void updateAllColors() {
		for (AnimatedColor c : AnimatedColor.values()) {
			c.update();
		}
	}

}
