package com.squad2.accenture.repository;

import com.squad2.accenture.model.VgeHabilidadesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VgeHabilidadeRepository extends JpaRepository<VgeHabilidadesModel, Integer>  {

    @Query(value = "SELECT id_habilidade,                      " +
            "              nome_habilidade,                    " +
            "              id_vaga                             " +
            "         FROM vge_habilidade                      " +
            "        where id_vaga = :idVaga                   ", nativeQuery = true)
    List<VgeHabilidadesModel> findByIdVaga(@Param("idVaga") Integer idVaga);

    @Query(value = "SELECT count(1)          " +
            "         from vge_habilidade    " +
            "        where id_vaga = :idVaga ", nativeQuery = true)
    Integer verificaVagaAssociada(@Param("idVaga") Integer idVaga);
}
