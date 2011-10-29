package org.tucana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tucana.domain.Constellation;

/**
 * Created by IntelliJ IDEA.
 * User: kamann
 * Date: 23.10.11
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public interface ConstellationRepository extends JpaRepository<Constellation, Long> {


    public Constellation findByCode(String code);

}
