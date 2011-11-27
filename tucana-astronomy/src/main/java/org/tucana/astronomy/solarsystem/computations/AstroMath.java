/**
 * 
 */
package org.tucana.astronomy.solarsystem.computations;

/**
 * @author kamann
 * 
 */
public class AstroMath {

	public static double round(double double2Format) {
		long temp = Math.round(((double2Format * Math.pow(10, 4))));
		return (((double) temp) / Math.pow(10, 4));
	}

	public static double fixDegress(double degrees) {
		if (degrees < 0 || degrees > 360) {
			degrees = degrees - Math.floor(degrees / 360.0) * 360.0;
		}
		return degrees;
	}

	public static double sin(double valueInDegrees) {
		return Math.sin(toRadians(valueInDegrees));
	}

	public static double cos(double valueInDegrees) {
		return Math.cos(toRadians(valueInDegrees));
	}

	public static double acos(double valueInDegrees) {
		return toDegree(Math.acos(valueInDegrees));
	}

	public static double atan2(double ordinate, double abcissa) {
		return Math.atan2(ordinate, abcissa);
	}

	public static double sqrt(double value) {
		return Math.sqrt(value);
	}

	public static double toRadians(double valueInDegrees) {
		return round(Math.toRadians(valueInDegrees));
	}

	public static double toDegree(double valueInRadians) {
		return round(Math.toDegrees(valueInRadians));
	}
}
