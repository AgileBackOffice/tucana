/**
 * 
 */
package org.tucana.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import org.tucana.domain.Constellation;

/**
 * @author kamann
 * 
 */
public class ConstellationRepositoryImpl implements
		ConstellationFulltextRepository {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tucana.repository.ConstellationFulltextRepository#findByFulltext(
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Constellation> findByFulltext(String search) {
		String[] fields = new String[] { "code", "name", "genitiveName",
				"author", "names.name" };
		MultiFieldQueryParser parser = new MultiFieldQueryParser(
				Version.LUCENE_31, fields, new StandardAnalyzer(
						Version.LUCENE_31));
		parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		parser.setAllowLeadingWildcard(true);

		FullTextQuery ftQuery;
		try {
			// search = fixSearchString(search);
			ftQuery = Search.getFullTextEntityManager(em).createFullTextQuery(
					parser.parse(search), Constellation.class);
			ftQuery.setSort(new Sort(new SortField("code", SortField.STRING)));

			List<Constellation> result = ftQuery.getResultList();
			Map<String, Constellation> groupedResult = new TreeMap<String, Constellation>();
			for (Constellation constellation : result) {
				groupedResult.put(constellation.getCode(), constellation);
			}
			return new ArrayList<Constellation>(groupedResult.values());
		} catch (ParseException e) {
			e.printStackTrace();
			return new ArrayList<Constellation>();
		}
	}

	public void reIndexDatabase(List<Constellation> constellations) {
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);
		for (Constellation constellation : constellations) {
			ftem.index(constellation);
		}
	}

}
