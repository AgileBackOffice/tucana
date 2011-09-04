package org.agilebackoffice.wafe.domain

import static org.junit.Assert.*

import javax.inject.Inject

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration
@Transactional
class ConstellationServiceIntegrationTest {

	@Inject
	ConstellationService service

	@Test
	final void "test retrieving all constallations"(){
		Assert.assertEquals(88, service.findAllConstellations().size())
	}

	@Test
	final void "test find constellation by his code"(){
		Assert.assertEquals("Orion", service.findConstellationByCode("ori").name)
	}

	@Test
	final void "test find all constellations by parts of his name"(){
		Assert.assertEquals(2, service.findAllConstellationByCodeOrName(null, "urs").size())
	}

	@Test
	final void "test find all constellations by parts of his code"(){
		Assert.assertEquals(5, service.findAllConstellationByCodeOrName("ca", null).size())
	}
}
