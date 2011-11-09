/**
 * 
 */
package org.tucana.repository;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.tucana.domain.Constellation
import org.tucana.service.ConstellationService

/**
 * @author kamann
 *
 */
@org.junit.runner.RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner)
@org.springframework.test.context.ContextConfiguration
class ConstellationServiceTest {
	private List<Constellation> data = []
	private ConstellationRepository repository
	private ConstellationService service

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		20.times { data << new Constellation(code: "c$it") }

		repository = [findAll: {data},
			findByCode: {code -> data.find{ it.code == code }},
			findByFulltext: {search -> data.findAll{it.code.startsWith(search)}}] as ConstellationRepository

		service = new ConstellationService()
		service.constellationRepository = repository
	}

	@Test
	final void "test service method findAllConstellations"(){
		Assert.assertEquals(20, service.findAllConstellations().size())
	}

	@Test
	final void "test service method findConstellationByCode"(){
		Assert.assertEquals("c3", service.findConstellationByCode("c3").code)
	}

	@Test
	final void "test failing service method findConstellationByCode"(){
		Assert.assertNull(service.findConstellationByCode("fghgh"))
	}

	@Test
	final void "test service method findAllConstellationByCodeOrName"(){
		Assert.assertEquals(11, service.findAllConstellationByCodeOrName("c1").size())
	}

	@Test
	final void "test service method findAllConstellationByCodeOrName with no results"(){
		Assert.assertEquals(0, service.findAllConstellationByCodeOrName("cer").size())
	}
}
