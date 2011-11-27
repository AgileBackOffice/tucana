/**
 * 
 */
package org.tucana.astronomy.entities;

import static org.tucana.astronomy.solarsystem.computations.AstroMath.fixDegress;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.round;

import org.tucana.astronomy.solarsystem.computations.AstroMath;

/**
 * @author kamann
 * 
 */
public class OrbitalElements {

	private double longitudeANode;
	private double inclination;
	private double argOfPerihelion;
	private double semiMajorAxis;
	private double eccentricity;
	private double meanAnomaly;
	private double oblOfEcliptic;

	/**
	 * @return longitude of the ascending node (N)
	 */
	public double getLongitudeANode() {
		return round(longitudeANode);
	}

	/**
	 * @param longitudeANode
	 *            longitude of the ascending node (N)
	 */
	public void setLongitudeANode(double longitudeANode) {
		this.longitudeANode = longitudeANode;
	}

	/**
	 * @return inclination to the ecliptic (plane of the Earth's orbit) (i)
	 */
	public double getInclination() {
		return round(inclination);
	}

	/**
	 * @param inclination
	 *            inclination to the ecliptic (plane of the Earth's orbit) (i)
	 */
	public void setInclination(double inclination) {
		this.inclination = inclination;
	}

	/**
	 * @return argument of perihelion (w)
	 */
	public double getArgOfPerihelion() {
		return round(argOfPerihelion);
	}

	/**
	 * @param argOfPerihelion
	 *            argument of perihelion (w)
	 */
	public void setArgOfPerihelion(double argOfPerihelion) {
		this.argOfPerihelion = argOfPerihelion;
	}

	/**
	 * @return semi-major axis, or mean distance from Sun (a)
	 */
	public double getSemiMajorAxis() {
		return round(semiMajorAxis);
	}

	/**
	 * @param semiMajorAxis
	 *            semi-major axis, or mean distance from Sun (a)
	 */
	public void setSemiMajorAxis(double semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	/**
	 * @return eccentricity (0=circle, 0-1=ellipse, 1=parabola) (e)
	 */
	public double getEccentricity() {
		return round(eccentricity);
	}

	/**
	 * @param eccentricity
	 *            eccentricity (0=circle, 0-1=ellipse, 1=parabola) (e)
	 */
	public void setEccentricity(double eccentricity) {
		this.eccentricity = eccentricity;
	}

	/**
	 * @return mean anomaly (0 at perihelion; increases uniformly with time) (M)
	 */
	public double getMeanAnomaly() {
		return round(fixDegress(meanAnomaly));
	}

	/**
	 * @param meanAnomaly
	 *            mean anomaly (0 at perihelion; increases uniformly with time)
	 *            (M)
	 */
	public void setMeanAnomaly(double meanAnomaly) {
		this.meanAnomaly = meanAnomaly;
	}

	/**
	 * @return the obliquity of the ecliptic, i.e. the "tilt" of the Earth's
	 *         axis of rotation (ecl)
	 */
	public double getOblOfEcliptic() {
		return round(oblOfEcliptic);
	}

	/**
	 * @param oblOfEcliptic
	 *            the obliquity of the ecliptic, i.e. the "tilt" of the Earth's
	 *            axis of rotation (ecl)
	 */
	public void setOblOfEcliptic(double oblOfEcliptic) {
		this.oblOfEcliptic = oblOfEcliptic;
	}

	/**
	 * @return the meanLongitude
	 */
	public double getMeanLongitude() {
		return round(fixDegress(argOfPerihelion + meanAnomaly));
	}

	// ---------------------------
	/**
	 * Longitude of the ascending node
	 * 
	 * @param n
	 *            the n to set
	 */
	public OrbitalElements withN(double n) {
		longitudeANode = n;
		return this;
	}

	/**
	 * Inclination to the ecliptic (plane of the Earth's orbit)
	 * 
	 * @param i
	 *            the i to set
	 */
	public OrbitalElements withI(double i) {
		this.inclination = i;
		return this;
	}

	/**
	 * Argument of perihelion
	 * 
	 * @param w
	 *            the w to set
	 */
	public OrbitalElements withW(double w) {
		this.argOfPerihelion = w;
		return this;
	}

	/**
	 * Semi-major axis, or mean distance from Sun
	 * 
	 * @param a
	 *            the a to set
	 */
	public OrbitalElements withA(double a) {
		this.semiMajorAxis = a;
		return this;
	}

	/**
	 * Eccentricity (0=circle, 0-1=ellipse, 1=parabola)
	 * 
	 * @param e
	 *            the e to set
	 */
	public OrbitalElements withE(double e) {
		this.eccentricity = e;
		return this;
	}

	/**
	 * Mean anomaly (0 at perihelion; increases uniformly with time)
	 * 
	 * @param m
	 *            the m to set
	 */
	public OrbitalElements withM(double m) {
		meanAnomaly = AstroMath.fixDegress(m);

		return this;
	}

	/**
	 * obliquity of the ecliptic
	 * 
	 * @param ecl
	 *            the ecl to set
	 */
	public OrbitalElements withEcl(double ecl) {
		this.oblOfEcliptic = ecl;
		return this;
	}

	/**
	 * @return the n
	 */
	public double getN() {
		return AstroMath.round(longitudeANode);
	}

	/**
	 * @return the i
	 */
	public double getI() {
		return AstroMath.round(inclination);
	}

	/**
	 * @return the w
	 */
	public double getW() {
		return AstroMath.round(argOfPerihelion);
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return AstroMath.round(semiMajorAxis);
	}

	/**
	 * @return the e
	 */
	public double getE() {
		return AstroMath.round(eccentricity);
	}

	/**
	 * @return the m
	 */
	public double getM() {
		return AstroMath.round(meanAnomaly);
	}

	/**
	 * @return the ecl
	 */
	public double getEcl() {
		return AstroMath.round(oblOfEcliptic);
	}

}
