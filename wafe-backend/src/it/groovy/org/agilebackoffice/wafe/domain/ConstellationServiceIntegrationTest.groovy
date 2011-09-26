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
	ConstellationService constellationService

	@Test
	final void "test retrieving all constallations"(){
		Assert.assertEquals(88, constellationService.findAllConstellations().size())
	}

	@Test
	final void "test find constellation by his code"(){
		Assert.assertEquals("Orion", constellationService.findConstellationByCode("ori").name)
	}

	@Test
	final void "test find all constellations by fulltextsearch"(){
		def result = constellationService.findAllConstellationByCodeOrName("lacerta")
		Assert.assertEquals(1, result.size())
		Assert.assertEquals("Lacerta", result.get(0).name)
	}
	
	@Test
	final void "test fulltextsearch with no results"(){
		Assert.assertEquals(0, constellationService.findAllConstellationByCodeOrName("xbcbcb").size())
	}
	
	@Test
	final void "test fulltextsearch with star placeholder"(){
		Assert.assertEquals(10, constellationService.findAllConstellationByCodeOrName("*ori*").size())
	}

	@Test
	final void "test fulltextsearch with multiple search items part of fullname"(){
		def result = constellationService.findAllConstellationByCodeOrName("ursa pisces")
		Assert.assertEquals(3, result.size())
	}
	
	@Test
	final void "test fulltextsearch with foreign name"(){
		def result = constellationService.findAllConstellationByCodeOrName("fische")
		Assert.assertEquals(1, result.size())
	}
	
	@Test
	final void "test fulltextsearch with multiple searchwords"(){
		Assert.assertEquals(2, constellationService.findAllConstellationByCodeOrName("ori umi").size())
	}
	
	@Test
	final void "test fulltextsearch with phrase"(){
		Assert.assertEquals(1, constellationService.findAllConstellationByCodeOrName("\"Ursa Major\"").size())
	}

	
	@Test
	final void "add a new comment to the constellation"(){
		
		def orion = constellationService.findConstellationByCode("ori");
		
		10.times{
			def comment = new Comment(comment: "comment$it", email: "email$it", name: "name$it")
			comment = constellationService.addCommentToConstellation(orion, comment);
			Assert.assertNotNull(comment.id)  
		}

		Assert.assertEquals(10,constellationService.findAllCommentsByConstellation(orion).size())
	}
	
	@Test
	final void "remove a comment from constellation"(){
		def orion = constellationService.findConstellationByCode("ori");
		
		10.times{
			def comment = new Comment(comment: "comment$it", email: "email$it", name: "name$it")
			comment = constellationService.addCommentToConstellation(orion, comment);
			Assert.assertNotNull(comment.id)
		}
		Assert.assertEquals(10,constellationService.findAllCommentsByConstellation(orion).size())
		
		constellationService.removeCommentFromConstellation(constellationService.findAllCommentsByConstellation(orion)[2])
		Assert.assertEquals(9,constellationService.findAllCommentsByConstellation(orion).size())
	}
	
	@Test
	final void "edit existing comment"(){
		def orion = constellationService.findConstellationByCode("ori");
		def comment = new Comment(comment: "comment", email: "email", name: "name")
		
		constellationService.addCommentToConstellation(orion, comment);
		comment = constellationService.findAllCommentsByConstellation(orion)[0]
		comment.setComment("edited");
		Assert.assertEquals("edited", constellationService.findAllCommentsByConstellation(orion)[0].comment)
	}
}
