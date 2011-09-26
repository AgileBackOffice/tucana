/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Repository;

/**
 * @author kamann
 *
 */
@Repository
public class ConstellationRepository {

	@PersistenceContext
	private EntityManager em;

	public Constellation persistConstellation(
			Constellation constellation2Persist) {
		if (constellation2Persist.getId() != null) {
			em.merge(constellation2Persist);
		} else {
			em.persist(constellation2Persist);
		}
		return constellation2Persist;
	}

	@SuppressWarnings("unchecked")
	public List<Constellation> findAllConstellations() {
		return em.createQuery("from Constellation c order by c.code").getResultList();
	}

	public Constellation findConstellationByCode(String code) {
		Query query = em
				.createQuery("from Constellation c where c.code = :code");
		query.setParameter("code", code);

		return (Constellation) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Constellation> findAllConstellationsByFullTextSearch(String search){
		
		String[] fields = new String[]{"code", "name", "genitiveName", "author", "names.name"};
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_31, fields, new StandardAnalyzer(Version.LUCENE_31));
		parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		parser.setAllowLeadingWildcard(true);
		
		FullTextQuery ftQuery;
		try {
			//search = fixSearchString(search);
			ftQuery = Search.getFullTextEntityManager(em).createFullTextQuery(parser.parse(search), Constellation.class);
			ftQuery.setSort(new Sort(new SortField("code", SortField.STRING)));
			
			List<Constellation> result = ftQuery.getResultList();
			Map< String, Constellation> groupedResult = new TreeMap<String, Constellation>();
			for (Constellation constellation : result) {
				groupedResult.put(constellation.getCode(), constellation);
			}		
			return new ArrayList<Constellation>(groupedResult.values());
		} catch (ParseException e) {
			e.printStackTrace();
			return new ArrayList<Constellation>();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Constellation> findAllConstellationsByConstellationNames(List<String> codes) {
		Query query = em
				.createQuery("from Constellation c where c.code in :codes Order By c.code");
		query.setParameter("codes", codes);
		
		return query.getResultList();
	}
	
	public void reIndexDatabase(){
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
		List<Constellation> constellations = findAllConstellations();
		for (Constellation constellation : constellations) {
			ftem.index(constellation);
		}
	}
	
	private String fixSearchString(String search){
		
		return (search.contains("\""))? search:  search.trim().replaceAll("  ", " ").replaceAll(" ", "* ")+"*";
	}

	/**
	 * @return the em
	 */
	public EntityManager getEntityManager() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	

}
