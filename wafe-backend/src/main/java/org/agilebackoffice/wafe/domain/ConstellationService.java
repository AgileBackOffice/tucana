/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kamann
 *
 */
@Service
@Transactional
public class ConstellationService {

	@Inject
	private ConstellationRepository cr;

	protected Constellation persistConstellation(
			Constellation constellation2Persist) {
		return cr.persistConstellation(constellation2Persist);
	}

	public List<Constellation> findAllConstellations() {
		return cr.findAllConstellations();
	}

	public Constellation findConstellationByCode(String code) {
		return cr.findConstellationByCode(code);
	}

	public List<Constellation> findAllConstellationByCodeOrName(String code,
			String name) {
		return cr
.findAllConstellationByCodeOrName(code, name);
	}

}
