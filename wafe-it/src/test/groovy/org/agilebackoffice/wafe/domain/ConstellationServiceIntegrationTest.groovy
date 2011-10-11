package org.agilebackoffice.wafe.domain

import static org.junit.Assert.*

import javax.inject.Inject

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional

@org.junit.runner.RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner)
@org.springframework.test.context.ContextConfiguration
@org.springframework.transaction.annotation.Transactional
class ConstellationServiceIntegrationTest {

	@javax.inject.Inject
	org.agilebackoffice.wafe.domain.ConstellationService constellationService

	@org.junit.Test
	final void "test retrieving all constellations"(){
		org.junit.Assert.assertEquals(88, constellationService.findAllConstellations().size())
	}

	@org.junit.Test
	final void "test find constellation by his code"(){
		org.junit.Assert.assertEquals("Orion", constellationService.findConstellationByCode("ori").name)
	}

	@org.junit.Test
	final void "test find all constellations by fulltextsearch"(){
		def result = constellationService.findAllConstellationByCodeOrName("lacerta")
		org.junit.Assert.assertEquals(1, result.size())
		org.junit.Assert.assertEquals("Lacerta", result.get(0).name)
	}
	
	@org.junit.Test
	final void "test fulltextsearch with no results"(){
		org.junit.Assert.assertEquals(0, constellationService.findAllConstellationByCodeOrName("xbcbcb").size())
	}
	
	@org.junit.Test
	final void "test fulltextsearch with star placeholder"(){
		org.junit.Assert.assertEquals(10, constellationService.findAllConstellationByCodeOrName("*ori*").size())
	}

	@org.junit.Test
	final void "test fulltextsearch with multiple search items part of fullname"(){
		def result = constellationService.findAllConstellationByCodeOrName("ursa pisces")
		org.junit.Assert.assertEquals(3, result.size())
	}
	
	@org.junit.Test
	final void "test fulltextsearch with foreign name"(){
		def result = constellationService.findAllConstellationByCodeOrName("fische")
		org.junit.Assert.assertEquals(1, result.size())
	}
	
	@org.junit.Test
	final void "test fulltextsearch with multiple searchwords"(){
		org.junit.Assert.assertEquals(2, constellationService.findAllConstellationByCodeOrName("ori umi").size())
	}
	
	@org.junit.Test
	final void "test fulltextsearch with phrase"(){
		org.junit.Assert.assertEquals(1, constellationService.findAllConstellationByCodeOrName("\"Ursa Major\"").size())
	}

	
	@org.junit.Test
	final void "add a new comment to the constellation"(){
		
		def orion = constellationService.findConstellationByCode("ori");
		
		10.times{
			def comment = new org.agilebackoffice.wafe.domain.Comment(comment: "comment$it", email: "email$it", name: "name$it")
			comment = constellationService.addCommentToConstellation(orion, comment);
			org.junit.Assert.assertNotNull(comment.id)
		}

		org.junit.Assert.assertEquals(10,constellationService.findAllCommentsByConstellation(orion).size())
	}
	
	@org.junit.Test
	final void "remove a comment from constellation"(){
		def orion = constellationService.findConstellationByCode("ori");
		
		10.times{
			def comment = new org.agilebackoffice.wafe.domain.Comment(comment: "comment$it", email: "email$it", name: "name$it")
			comment = constellationService.addCommentToConstellation(orion, comment);
			org.junit.Assert.assertNotNull(comment.id)
		}
		org.junit.Assert.assertEquals(10,constellationService.findAllCommentsByConstellation(orion).size())
		
		constellationService.removeCommentFromConstellation(constellationService.findAllCommentsByConstellation(orion)[2])
		org.junit.Assert.assertEquals(9,constellationService.findAllCommentsByConstellation(orion).size())
	}
	
	@org.junit.Test
	final void "edit existing comment"(){
		def orion = constellationService.findConstellationByCode("ori");
		def comment = new org.agilebackoffice.wafe.domain.Comment(comment: "comment", email: "email", name: "name")
		
		constellationService.addCommentToConstellation(orion, comment);
		comment = constellationService.findAllCommentsByConstellation(orion)[0]
		comment.setComment("edited");
		org.junit.Assert.assertEquals("edited", constellationService.findAllCommentsByConstellation(orion)[0].comment)
	}
}
