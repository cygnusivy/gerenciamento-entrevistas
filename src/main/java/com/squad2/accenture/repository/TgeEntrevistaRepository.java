package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeEnderecoModel;
import com.squad2.accenture.model.TgeEntrevistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeEntrevistaRepository extends JpaRepository<TgeEntrevistaModel, Integer> {
}