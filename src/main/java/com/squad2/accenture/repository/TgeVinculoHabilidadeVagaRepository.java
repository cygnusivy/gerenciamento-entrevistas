package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeVinculoHabilidadeVagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeVinculoHabilidadeVagaRepository extends JpaRepository<TgeVinculoHabilidadeVagaModel, Integer> {

    Boolean existsByIdHabilidadeAndIdVaga(Integer idHabilidade, Integer idVaga);

    TgeVinculoHabilidadeVagaModel findByIdHabilidadeAndIdVaga(Integer idHabilidade, Integer idVaga);
}