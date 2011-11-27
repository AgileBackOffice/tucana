/**
 * 
 */
package org.tucana.astronomy.solarsystem.computations;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Assert
import org.junit.Test

/**
 * @author kamann
 *
 */
class AstroDateTest {

	@Test
	public final void "test compute day number from 1990 april 19"(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Assert.assertEquals(-3543.0, AstroDate.computeDayNumber(formatter.parse("1990/04/19 0:00")), 0)
	}

	@Test
	public final void "test convert datetime object into a decimal time"(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");

		Assert.assertEquals(0, AstroDate.convertTimeIntoDecimalTime(formatter.parse("1990/4/19 0:00")), 0)
		Assert.assertEquals(6.75, AstroDate.convertTimeIntoDecimalTime(formatter.parse("1990/4/19 6:45")), 0)
		Assert.assertEquals(18.33, AstroDate.convertTimeIntoDecimalTime(formatter.parse("1990/4/19 18:20")), 0.01)
	}
}
