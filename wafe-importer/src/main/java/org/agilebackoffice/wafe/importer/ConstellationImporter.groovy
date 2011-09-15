/**
 * 
 */
package org.agilebackoffice.wafe.importer

import groovy.util.slurpersupport.NodeChild

import org.agilebackoffice.wafe.domain.Constellation
import org.agilebackoffice.wafe.domain.ConstellationService
import org.htmlcleaner.HtmlCleaner
import org.htmlcleaner.SimpleXmlSerializer
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * @author kamann
 *
 */
class ConstellationImporter {

	public static void main(def args){

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/backend-context.xml")

		ConstellationService service = applicationContext.getBean("constellationService")


		String url = "http://de.wikipedia.org/wiki/Liste_der_Sternbilder"
		def page = getCleanedHtml(url)
		def tables = page.body.'**'.findAll{
			it.name() == "table" && it.@class.text().contains('wikitable sortable')
		}

		if (tables.size() != 1){
			throw new RuntimeException("Expected only one table. Please check the xpath and the source of wikipedia!")
		}

		def table = tables[0]
		def rows = table.tbody.tr


		rows.each{ row ->
			if (!row.@style.text()){
				def cells = row.td
				Constellation constellation = new Constellation()
				constellation.germanName = cells[0]
				constellation.name = cells[1]
				constellation.genitiveName = cells[2]
				constellation.code = cells[3].text().toLowerCase()
				constellation.hemisphere = cells[4]
				constellation.author = cells[5]
				constellation.authorYear = cells[6].text() as int
				constellation.area = toDouble(cells[7].text())
				constellation.visibilityArea = cells[8].text().replace("bis", "-")
				constellation.greatestMagnitude = toDouble(cells[9].text())
				constellation.numberOfStarsGreater3M = cells[10].text() as int
				constellation.numberOfStarsGreater4M = cells[11].text() as int
				constellation.starCardRef = retrieveStarCardRef(cells[12].a.@href.text())
				constellation.starCardData = new URL(retrieveStarCardRef(cells[12].a.@href.text())).bytes
				
				println constellation
				service.persistConstellation constellation
			}	else{
				println "a"
			}
		}

		println service.findAllConstellations().size()
		println service.findConstellationByCode("ori").name
	}

	private static toDouble(String value){
		return (value.replaceAll("\\.", "").replace(",", ".")) as double
	}

	private static retrieveStarCardRef(String wikipediaRef){
		def url = "http://de.wikipedia.org$wikipediaRef"
		def page = getCleanedHtml(url)
		def pngUrl = page.body.'**'.find{ it.name() == "div" && it.@class.text().contains('fullMedia')}.a.@href.text()
	}

	private static NodeChild getCleanedHtml(String url){
		def cleaner = new HtmlCleaner()
		def node = cleaner.clean(url.toURL())

		// Convert from HTML to XML
		def props = cleaner.getProperties()
		def serializer = new SimpleXmlSerializer(props)
		def xml = serializer.getXmlAsString(node)

		// Parse the XML into a document we can work with
		new XmlSlurper(false,false).parseText(xml)
	}
}
