package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeIdiomaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

public interface TgeIdiomaRepository extends JpaRepository<TgeIdiomaModel, Integer> {

    TgeIdiomaModel findByIdIdioma(Integer idIdioma);

    Boolean existsByIdioma(String idioma);

}
