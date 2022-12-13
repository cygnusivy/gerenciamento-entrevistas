package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeEnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeEnderecoRepository extends JpaRepository<TgeEnderecoModel, Integer> {

    TgeEnderecoModel findByCandidatoCpf(String cpf);
}