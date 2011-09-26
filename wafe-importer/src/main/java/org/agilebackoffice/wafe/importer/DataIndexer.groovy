/**
 * 
 */
package org.agilebackoffice.wafe.importer

import org.agilebackoffice.wafe.domain.ConstellationRepository
import org.agilebackoffice.wafe.domain.ConstellationService
import org.hibernate.search.jpa.Search
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * @author kamann
 *
 */
class DataIndexer {

	static main(args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/backend-context.xml")
		ConstellationService service = applicationContext.getBean("constellationService")
		ConstellationRepository repository = applicationContext.getBean("constellationRepository")
		
		def ftem = Search.getFullTextEntityManager(repository.em)
		List constellations = service.findAllConstellations()
		constellations.each {  
			ftem.index(it)
		}
	}
}
