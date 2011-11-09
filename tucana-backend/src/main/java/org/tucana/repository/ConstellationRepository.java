package org.tucana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tucana.domain.Constellation;

public interface ConstellationRepository extends JpaRepository<Constellation, Long>, ConstellationFulltextRepository {


    Constellation findByCode(String code);
    
    void reIndexDatabase(List<Constellation> constellations);

}
