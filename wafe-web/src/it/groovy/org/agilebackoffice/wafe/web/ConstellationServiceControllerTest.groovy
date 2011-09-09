package org.agilebackoffice.wafe.web;

import static org.junit.Assert.*

import org.agilebackoffice.wafe.domain.Constellation
import org.junit.Test

import com.thoughtworks.xstream.XStream

class ConstellationServiceControllerTest {
	final String baseUrl = "http://localhost:8080/wafe-web/constellation"
	
	@Test
	final void "test retrieve all constellations as xml"(){
		String url = "$baseUrl/constellations/"
		
		def result = retrieveRemoteObjectOverXml(url)
		assertEquals(88, result.size())
	}
	
	@Test
	final void "test retrieve only one constellation by its code"(){
		String url = "$baseUrl/constellation_by_code/peg"
		Constellation constellation = retrieveRemoteObjectOverXml(url)
		
		assertEquals("Pegasus", constellation.name)
	}
	
	@Test
	final void "test retrieve constellations by a search token"(){
		String url = "$baseUrl/constellation_by_search/um"
		def constellations = retrieveRemoteObjectOverXml(url)
		
		assertEquals(2, constellations.size())
	}
	
	private def retrieveRemoteObjectOverXml(String url){
		return new XStream().fromXML(new URL(url).getText())
	}

}
