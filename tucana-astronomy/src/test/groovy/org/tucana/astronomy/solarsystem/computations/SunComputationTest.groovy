package org.tucana.astronomy.solarsystem.computations;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SunComputationTest {
	private SunComputation sunComputation
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");

	@Before
	public void prepare(){
		sunComputation = new SunComputation(formatter.parse("1990/04/19 00:00"));
	}

	@Test
	public final void "test get suns orbital elements for 1990 april 19"(){
		sunComputation.computeOrbitalElements()
		Assert.assertEquals 282.7735, sunComputation.orbitalElements.argOfPerihelion, 0
		Assert.assertEquals 1.0, sunComputation.orbitalElements.semiMajorAxis, 0
		Assert.assertEquals 0.0167, sunComputation.orbitalElements.eccentricity, 0
		Assert.assertEquals 104.0653, sunComputation.orbitalElements.meanAnomaly, 0
		Assert.assertEquals 23.4406, sunComputation.orbitalElements.oblOfEcliptic, 0
		Assert.assertEquals(26.8388, sunComputation.orbitalElements.meanLongitude, 0)
	}

	@Test
	public final void "test compute eccentric anomaly"(){
		Assert.assertEquals(104.9904, sunComputation.computeEccentricAnomaly(), 0.01)
	}

	@Test
	public final void "test compute the rectagular coordinates"(){
		def coords = sunComputation.computeRectangularCoordinates()

		Assert.assertEquals(-0.275370, coords.x, 0.0001)
		Assert.assertEquals(+0.965834, coords.y, 0.0001)
	}

	@Test
	public final void "test compute the distance"(){
		Assert.assertEquals(1.004323, sunComputation.computeDistance(), 0.0001)
	}

	@Test
	public final void "test compute the true anomaly"(){
		Assert.assertEquals(105.9134, sunComputation.computeTrueAnomaly(), 0.01)
	}

	@Test
	public final void "test compute the longitude"(){
		Assert.assertEquals(28.6869, sunComputation.computeLongitude(), 0.01)
	}

	@Test
	public final void "test compute ecliptic coordinates"(){
		def xyz = sunComputation.computeEclipticCoordinates()

		Assert.assertEquals(0.881048, xyz.x, 0.0001)
		Assert.assertEquals(0.482098, xyz.y, 0.0001)
		Assert.assertEquals(0.0, xyz.z, 0)
	}

	@Test
	public final void "test compute equatorial coordinates"(){
		def xyz = sunComputation.computeEquatorialCoordinates()

		Assert.assertEquals(0.881048, xyz.x, 0.001)
		Assert.assertEquals(0.442312, xyz.y, 0.001)
		Assert.assertEquals(0.191778, xyz.z, 0.001)
	}

	@Test
	public final void "test compute position"(){
		def xyz = sunComputation.computePosition()

		Assert.assertEquals(1.004323, xyz.distance, 0.001)
		Assert.assertEquals(26.6580, xyz.rightAscension, 0.01)
		Assert.assertEquals(11.008, xyz.declination, 0.01)
	}

	@Test
	public final void "test compute position with altitude and azimuth"(){
		def xyz = sunComputation.computePosition(60, 15)

		Assert.assertEquals(1.004323, xyz.distance, 0.001)
		Assert.assertEquals(26.6580, xyz.rightAscension, 0.01)
		Assert.assertEquals(11.008, xyz.declination, 0.01)
		Assert.assertEquals(15.6767, xyz.azimuth, 0.01)
		Assert.assertEquals(-17.9570, xyz.altitude, 0.01)
	}

	@Test
	public final void "test compute siderial time at greenwich meridian"(){
		Assert.assertEquals(13.78925, sunComputation.computeGreenwichMeridianSiderialTime(), 0.0001)
	}

	@Test
	public final void "test compute siderial time for 1990 april 19 at a longitude of 15 degree"(){
		Assert.assertEquals(14.78925, sunComputation.computeSiderialTime(15), 0.0001)
	}

	@Test
	public final void "test compute hour angle for 1990 april 19 at a longitude of 15 degree"(){
		Assert.assertEquals(195.1851, sunComputation.computeHourAngle(15), 0.0001);
	}

	@Test
	public final void "test compute rise and set"(){
		def sc = new SunComputation(formatter.parse("2011/11/26 12:00"))

		def rs = sc.computeRiseAndSet(50, 9)
		println "r: "+ AstroConverter.toTimeString(rs[0])
		println "n: "+AstroConverter.toTimeString(rs[1])
		println "s: "+AstroConverter.toTimeString(rs[2])
	}

	//	@Test
	//	public final void "test for now"(){
	//		double[] xyz = new Sun(2011, 11, 25, 0, 0).computePosition()
	//
	//		println xyz[0]
	//		println xyz[1]/15
	//		println xyz[2]
	//	}
}
