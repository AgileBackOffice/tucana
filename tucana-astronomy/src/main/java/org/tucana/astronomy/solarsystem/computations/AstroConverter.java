/**
 * 
 */
package org.tucana.astronomy.solarsystem.computations;

import static org.tucana.astronomy.solarsystem.computations.AstroMath.round;

/**
 * @author kamann
 * 
 */
public class AstroConverter {

	public static String toDMS(final double degree) {
		int hours = (int) degree;
		double minutes = ((degree - hours) * 60);
		double seconds = (minutes - ((int) minutes)) * 60;

		return hours + "¡ " + (int) minutes + "' " + round(seconds) + "\"";
	}

	public static String toHMS(final double degree) {
		int hours = (int) degree / 15;
		double minutes = ((degree / 15 - hours) * 60);
		double seconds = (minutes - ((int) minutes)) * 60;

		return hours + "h " + (int) minutes + "m " + round(seconds) + "s";
	}

	public static String toTimeString(final double decimalTime) {
		int hours = (int) decimalTime;
		double minutes = ((decimalTime - hours) * 60);
		double seconds = (minutes - ((int) minutes)) * 60;

		return hours + ":" + (int) minutes + ":" + round(seconds);
	}

}
