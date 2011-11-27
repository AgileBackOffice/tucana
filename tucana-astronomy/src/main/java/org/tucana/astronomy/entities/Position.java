/**
 * 
 */
package org.tucana.astronomy.entities;

/**
 * @author kamann
 * 
 */
public class Position {
	private double declination;
	private double rightAscension;
	private double distance;
	private double azimuth;
	private double altitude;

	/**
	 * @return the declination
	 */
	public double getDeclination() {
		return declination;
	}

	/**
	 * @param declination
	 *            the declination to set
	 */
	public void setDeclination(double declination) {
		this.declination = declination;
	}

	/**
	 * @return the rightAscension
	 */
	public double getRightAscension() {
		return rightAscension;
	}

	/**
	 * @param rightAscension
	 *            the rightAscension to set
	 */
	public void setRightAscension(double rightAscension) {
		this.rightAscension = rightAscension;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the azimuth
	 */
	public double getAzimuth() {
		return azimuth;
	}

	/**
	 * @param azimuth
	 *            the azimuth to set
	 */
	public void setAzimuth(double azimuth) {
		this.azimuth = azimuth;
	}

	/**
	 * @return the altitude
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude
	 *            the altitude to set
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

}
