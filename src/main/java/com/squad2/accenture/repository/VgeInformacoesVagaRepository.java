package com.squad2.accenture.repository;

import com.squad2.accenture.model.VgeInformacoesVagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VgeInformacoesVagaRepository extends JpaRepository<VgeInformacoesVagaModel, Integer> {

    VgeInformacoesVagaModel findByIdVaga(Integer idVagas);
}