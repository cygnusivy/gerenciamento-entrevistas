package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeTelefoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeTelefoneRepository extends JpaRepository<TgeTelefoneModel, Integer> {

    Boolean existsByNumero(String numero);

    TgeTelefoneModel findByNumero(String numero);

    TgeTelefoneModel findByCandidatoCpf(String cpf);
}