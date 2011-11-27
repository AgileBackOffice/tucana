package org.tucana.astronomy.solarsystem;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SunTest {
	private Sun sun

	@Before
	public void prepare(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		sun = new Sun(formatter.parse("1990/04/19 00:00"));
	}

	@Test
	public final void "test compute ecliptic coordinates"(){
		def xyz = sun.eclipticCoordinates

		Assert.assertEquals(0.881048, xyz.x, 0.0001)
		Assert.assertEquals(0.482098, xyz.y, 0.0001)
		Assert.assertEquals(0.0, xyz.z, 0)
	}

	@Test
	public final void "test compute equatorial coordinates"(){
		def xyz = sun.equatorialCoordinates

		Assert.assertEquals(0.881048, xyz.x, 0.001)
		Assert.assertEquals(0.442312, xyz.y, 0.001)
		Assert.assertEquals(0.191778, xyz.z, 0.001)
	}

	@Test
	public final void "test compute position"(){
		def xyz = sun.position

		Assert.assertEquals(1.004323, xyz.distance, 0.001)
		Assert.assertEquals(26.6580, xyz.rightAscension, 0.01)
		Assert.assertEquals(11.008, xyz.declination, 0.01)
	}
}
