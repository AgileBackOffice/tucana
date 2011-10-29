package org.tucana.repository;

import org.tucana.domain.Constellation;

import java.util.List;

/**
 *
 */
public interface ConstellationFulltextRepository {

    public List<Constellation> findByFulltext(String search);
}
