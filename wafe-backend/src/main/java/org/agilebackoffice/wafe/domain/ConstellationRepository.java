/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.WildcardQuery;
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
		return em.createQuery("from Constellation c").getResultList();
	}

	public Constellation findConstellationByCode(String code) {
		Query query = em
				.createQuery("from Constellation c where c.code = :code");
		query.setParameter("code", code);

		return (Constellation) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Constellation> findAllConstellationByCodeOrName(String search) {
		BooleanQuery bq = new BooleanQuery();
		search = "*"+search+"*";
		bq.add(new WildcardQuery(new Term("code", search)), BooleanClause.Occur.SHOULD);
		bq.add(new WildcardQuery(new Term("name", search)), BooleanClause.Occur.SHOULD);
		bq.add(new WildcardQuery(new Term("author", search)), BooleanClause.Occur.SHOULD);
		bq.add(new WildcardQuery(new Term("genetiveName", search)), BooleanClause.Occur.SHOULD);

		FullTextQuery ftQuery = Search.getFullTextEntityManager(em).createFullTextQuery(bq, Constellation.class);
		return ftQuery.getResultList();
	}

}
