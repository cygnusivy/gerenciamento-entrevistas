package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.model.TgeStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeStatusReposytory extends JpaRepository<TgeStatusModel, Integer> {

    Boolean existsByNomeStatus(String nomeStatus);

    TgeIdiomaModel findByNomeStatus(String nomeStatus);

    TgeStatusModel findByCodStatus(String cod);
}