package com.squad2.accenture.repository;

import com.squad2.accenture.model.VgeInformacoesVagaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VgeInformacoesVagaRepository extends JpaRepository<VgeInformacoesVagaModel, Integer> {

    VgeInformacoesVagaModel findByIdVaga(Integer idVagas);
}
