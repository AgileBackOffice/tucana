package org.tucana.astronomy.solarsystem.computations;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test

class AstroConverterTest {

	@Test
	public final void "test convert degree into degrees minutes and seconds"(){
		Assert.assertEquals("123¡ 27' 22.9572\"", AstroConverter.toDMS(123.456377))
	}

	@Test
	public final void "test convert degree into hours minutes and seconds"(){
		Assert.assertEquals("1h 46m 37.92s", AstroConverter.toHMS(26.6580))
	}
}
