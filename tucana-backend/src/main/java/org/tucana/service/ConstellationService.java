/**
 * 
 */
package org.tucana.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tucana.domain.Constellation;
import org.tucana.repository.ConstellationRepositoryOld;

import javax.inject.Inject;
import java.util.List;

/**
 * @author kamann
 * 
 */
@Service
@Transactional
public class ConstellationService {

	@Inject
	private ConstellationRepositoryOld constellationRepository;


	public Constellation persistConstellation(
			Constellation constellation2Persist) {
		return constellationRepository
				.persistConstellation(constellation2Persist);
	}
	
	public void reIndexDatabase(){
		constellationRepository.reIndexDatabase();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.agilebackoffice.wafe.domain.IConstellation#findAllConstellations()
	 */
	public List<Constellation> findAllConstellations() {
		return constellationRepository.findAllConstellations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.agilebackoffice.wafe.domain.IConstellation#findConstellationByCode
	 * (java.lang.String)
	 */
	public Constellation findConstellationByCode(String code) {
		return constellationRepository.findConstellationByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.agilebackoffice.wafe.domain.IConstellation#
	 * findAllConstellationByCodeOrName(java.lang.String)
	 */
	public List<Constellation> findAllConstellationByCodeOrName(String search) {
		return constellationRepository
				.findAllConstellationsByFullTextSearch(search);
	}
}
