/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		Query query = em
				.createQuery("from Constellation c where c.code like :search OR c.name like :search");
		query.setParameter("search", "%" + search + "%");

		return query.getResultList();
	}

}
