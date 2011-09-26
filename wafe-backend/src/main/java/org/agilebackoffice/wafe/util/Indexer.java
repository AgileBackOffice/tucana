/**
 * 
 */
package org.agilebackoffice.wafe.util;

import java.util.List;

import org.agilebackoffice.wafe.domain.Constellation;
import org.agilebackoffice.wafe.domain.ConstellationRepository;
import org.agilebackoffice.wafe.domain.ConstellationService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kamann
 *
 */
public class Indexer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/backend-context.xml");
		ConstellationService service = (ConstellationService) applicationContext.getBean("constellationService");
		
		service.reIndexDatabase();
	}

}
