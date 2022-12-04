package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeIdiomaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgeIdiomaRepository extends JpaRepository<TgeIdiomaModel, Integer> {

    TgeIdiomaModel findByIdIdioma(Integer idIdioma);
}
