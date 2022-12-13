package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeCandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeCandidatoRepository extends JpaRepository<TgeCandidatoModel, Integer> {

    Boolean existsByCpf(String cpf);

    TgeCandidatoModel findByCpf(String cpf);
}