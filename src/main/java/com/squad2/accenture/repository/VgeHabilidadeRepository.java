package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeHabilidadesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VgeHabilidadeRepository extends JpaRepository<TgeHabilidadesModel, Integer>  {

    @Query(value = "SELECT id_habilidade,                      " +
            "              nome_habilidade,                    " +
            "              id_vaga                             " +
            "         FROM vge_habilidade                      " +
            "        where id_vaga = :idVaga                   ", nativeQuery = true)
    List<TgeHabilidadesModel> findByIdVaga(@Param("idVaga") Integer idVaga);
}
