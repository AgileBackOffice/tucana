/**
 * 
 */
package org.tucana.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tucana.domain.Constellation;
import org.tucana.repository.ConstellationRepository;

/**
 * @author kamann
 * 
 */
@Service
@Transactional
public class ConstellationService {

	@Inject
	private ConstellationRepository constellationRepository;

	public Constellation persistConstellation(
			Constellation constellation2Persist) {
		return constellationRepository.save(constellation2Persist);
	}

	public void reIndexDatabase() {
		constellationRepository.reIndexDatabase(constellationRepository
				.findAll());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.agilebackoffice.wafe.domain.IConstellation#findAllConstellations()
	 */
	public List<Constellation> findAllConstellations() {
		return constellationRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.agilebackoffice.wafe.domain.IConstellation#findConstellationByCode
	 * (java.lang.String)
	 */
	public Constellation findConstellationByCode(String code) {
		return constellationRepository.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.agilebackoffice.wafe.domain.IConstellation#
	 * findAllConstellationByCodeOrName(java.lang.String)
	 */
	public List<Constellation> findAllConstellationByCodeOrName(String search) {
		return constellationRepository.findByFulltext(search);
	}
}
