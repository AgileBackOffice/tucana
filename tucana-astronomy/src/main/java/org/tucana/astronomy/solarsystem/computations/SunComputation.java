/**
 * 
 */
package org.tucana.astronomy.solarsystem.computations;

import static org.tucana.astronomy.solarsystem.computations.AstroDate.computeDayNumber;
import static org.tucana.astronomy.solarsystem.computations.AstroDate.convertTimeIntoDecimalTime;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.acos;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.atan2;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.cos;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.fixDegress;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.round;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.sin;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.sqrt;
import static org.tucana.astronomy.solarsystem.computations.AstroMath.toDegree;

import java.util.Date;

import org.tucana.astronomy.entities.Coordinate;
import org.tucana.astronomy.entities.OrbitalElements;
import org.tucana.astronomy.entities.Position;

/**
 * @author kamann
 * 
 */
public class SunComputation {
	private Date computationDate;
	private double dayNumber = Double.MAX_VALUE;
	private OrbitalElements orbitalElements;
	private double eccentricAnomaly;
	private Coordinate rectangularCoordinates;
	private double distance;
	private double trueAnomaly;
	private double longitude;
	private Coordinate eclipticCoordinates;
	private Coordinate equatorialCoordinates;
	private Position position;
	private double gmst0;
	private double siderialTime;
	private double hourAngle;
	private double sunrise;
	private double sunset;
	private double apex;

	public SunComputation(Date computationDate) {
		this.computationDate = computationDate;
		dayNumber = computeDayNumber(computationDate);
	}

	/**
	 * Computes all data and elements
	 */
	public void computeAllElements() {
		computePosition();
	}

	/**
	 * @return the dayNumber
	 */
	public double getDayNumber() {
		return dayNumber;
	}

	/**
	 * @return the orbitalElements
	 */
	public OrbitalElements getOrbitalElements() {
		return orbitalElements;
	}

	/**
	 * @return the eccentricAnomaly
	 */
	public double getEccentricAnomaly() {
		return eccentricAnomaly;
	}

	/**
	 * @return the rectangularCoordinates
	 */
	public Coordinate getRectangularCoordinates() {
		return rectangularCoordinates;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @return the trueAnomaly
	 */
	public double getTrueAnomaly() {
		return trueAnomaly;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the eclipticCoordinates
	 */
	public Coordinate getEclipticCoordinates() {
		return eclipticCoordinates;
	}

	/**
	 * @return the equatorialCoordinates
	 */
	public Coordinate getEquatorialCoordinates() {
		return equatorialCoordinates;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return the gmst0
	 */
	public double getGreenwichMeridianSiderialTime() {
		return gmst0;
	}

	/**
	 * @return the siderialTime
	 */
	public double getSiderialTime() {
		return siderialTime;
	}

	/**
	 * @return the hourAngle
	 */
	public double getHourAngle() {
		return hourAngle;
	}

	public double getRiseTime(double latitude, double longitude) {
		computeRiseAndSet(latitude, longitude);
		return sunrise;
	}

	public double getApexTime(double latitude, double longitude) {
		computeRiseAndSet(latitude, longitude);
		return apex;
	}

	public double getSetTime(double latitude, double longitude) {
		computeRiseAndSet(latitude, longitude);
		return sunset;
	}

	protected OrbitalElements computeOrbitalElements() {
		orbitalElements = new OrbitalElements();
		orbitalElements.setLongitudeANode(0.0);
		orbitalElements.setInclination(0.0);
		orbitalElements.setArgOfPerihelion(282.9404 + 4.70935E-5 * dayNumber);
		orbitalElements.setSemiMajorAxis(1.000000);
		orbitalElements.setEccentricity(0.016709 - 1.151E-9 * dayNumber);
		orbitalElements.setMeanAnomaly(356.0470 + 0.9856002585 * dayNumber);
		orbitalElements.setOblOfEcliptic(23.4393 - 3.563E-7 * dayNumber);
		return orbitalElements;
	}

	protected double computeDistance() {
		Coordinate coords = computeRectangularCoordinates();

		distance = sqrt(coords.getX() * coords.getX() + coords.getY()
				* coords.getY());
		return distance;

	}

	protected double computeEccentricAnomaly() {
		computeOrbitalElements();
		eccentricAnomaly = round(orbitalElements.getMeanAnomaly()
				+ (180 / Math.PI)
				* orbitalElements.getEccentricity()
				* sin(orbitalElements.getMeanAnomaly())
				* (1 + orbitalElements.getEccentricity()
						* cos(orbitalElements.getMeanAnomaly())));
		return eccentricAnomaly;

	}

	protected Coordinate computeEclipticCoordinates() {
		computeLongitude();
		computeDistance();
		eclipticCoordinates = new Coordinate();

		eclipticCoordinates.setX(distance * cos(longitude));
		eclipticCoordinates.setY(distance * sin(longitude));
		eclipticCoordinates.setZ(0.0);

		return eclipticCoordinates;

	}

	protected Coordinate computeEquatorialCoordinates() {
		computeEclipticCoordinates();
		equatorialCoordinates = new Coordinate();

		equatorialCoordinates.setX(eclipticCoordinates.getX());
		equatorialCoordinates.setY(eclipticCoordinates.getY()
				* cos(orbitalElements.getOblOfEcliptic())
				- eclipticCoordinates.getZ()
				* sin(orbitalElements.getOblOfEcliptic()));
		equatorialCoordinates.setZ(eclipticCoordinates.getY()
				* sin(orbitalElements.getOblOfEcliptic())
				+ eclipticCoordinates.getZ()
				* cos(orbitalElements.getOblOfEcliptic()));

		return equatorialCoordinates;

	}

	protected double computeLongitude() {
		longitude = round(fixDegress(computeTrueAnomaly()
				+ orbitalElements.getArgOfPerihelion()));
		return longitude;
	}

	protected Position computePosition() {
		computeEquatorialCoordinates();
		position = new Position();

		position.setDistance(computeDistance());
		position.setRightAscension(fixDegress(toDegree(atan2(
				equatorialCoordinates.getY(), equatorialCoordinates.getX()))));
		position.setDeclination(toDegree(atan2(
				equatorialCoordinates.getZ(),
				sqrt(equatorialCoordinates.getX()
						* equatorialCoordinates.getX()
						+ equatorialCoordinates.getY()
						* equatorialCoordinates.getY()))));
		return position;
	}

	protected Position computePosition(double latitude, double longitude) {
		computePosition();

		computeHourAngle(longitude);
		double x = cos(hourAngle) * cos(position.getDeclination());
		double y = sin(hourAngle) * cos(position.getDeclination());
		double z = sin(position.getDeclination());

		double xhor = x * sin(latitude) - z * cos(latitude);
		double yhor = y;
		double zhor = x * cos(latitude) + z * sin(latitude);

		position.setAzimuth(fixDegress(toDegree(atan2(yhor, xhor)) + 180));
		position.setAltitude(toDegree(atan2(zhor, sqrt(xhor * xhor + yhor
				* yhor))));
		return position;
	}

	protected Coordinate computeRectangularCoordinates() {
		computeEccentricAnomaly();
		rectangularCoordinates = new Coordinate();

		rectangularCoordinates.setX(cos(eccentricAnomaly)
				- orbitalElements.getEccentricity());
		rectangularCoordinates.setY(sin(eccentricAnomaly)
				* sqrt(1 - orbitalElements.getEccentricity()
						* orbitalElements.getEccentricity()));

		return rectangularCoordinates;

	}

	protected double computeTrueAnomaly() {
		Coordinate coords = computeRectangularCoordinates();

		trueAnomaly = toDegree(atan2(coords.getY(), coords.getX()));
		return trueAnomaly;
	}

	protected double computeGreenwichMeridianSiderialTime() {
		computeOrbitalElements();
		gmst0 = fixDegress((orbitalElements.getMeanLongitude() + 180)) / 15;
		return gmst0;
	}

	protected double computeSiderialTime(double longitude) {
		computeGreenwichMeridianSiderialTime();

		siderialTime = gmst0 + (convertTimeIntoDecimalTime(computationDate))
				+ longitude / 15;
		return siderialTime;
	}

	protected double computeHourAngle(double longitude) {
		computePosition();
		computeSiderialTime(longitude);

		hourAngle = (siderialTime - position.getRightAscension() / 15) * 15;
		return hourAngle;
	}

	protected double[] computeRiseAndSet(double latitude, double longitude) {
		computePosition();
		computeGreenwichMeridianSiderialTime();

		apex = (position.getRightAscension() - gmst0 * 15 - longitude)
				/ AstroContants.DEGREE_PER_HOUR;

		double lha = (sin(-0.833) - sin(latitude)
				* sin(position.getDeclination()))
				/ (cos(latitude) * cos(position.getDeclination()));

		sunset = acos(lha) / AstroContants.DEGREE_PER_HOUR + apex;
		sunrise = apex - acos(lha) / AstroContants.DEGREE_PER_HOUR;
		return new double[] { sunrise, apex, sunset };
	}
}
