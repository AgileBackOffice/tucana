/**
 * 
 */
package org.tucana.astronomy.solarsystem;

import java.util.Date;

import org.tucana.astronomy.entities.Coordinate;
import org.tucana.astronomy.entities.Position;
import org.tucana.astronomy.solarsystem.computations.SunComputation;

/**
 * 
 */
public class Sun {

	private SunComputation sunComputation;

	public Sun(Date date) {
		sunComputation = new SunComputation(date);
		sunComputation.computeAllElements();
	}

	public Position getPosition() {
		return sunComputation.getPosition();
	}

	public Coordinate getEclipticCoordinates() {
		return sunComputation.getEclipticCoordinates();
	}

	public Coordinate getEquatorialCoordinates() {
		return sunComputation.getEquatorialCoordinates();
	}
}
