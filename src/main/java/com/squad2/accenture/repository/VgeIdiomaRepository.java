package com.squad2.accenture.repository;

import com.squad2.accenture.model.VgeIdiomaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VgeIdiomaRepository extends JpaRepository<VgeIdiomaModel, Integer> {

    @Query(value = "SELECT id_idioma,        " +
            "              nome_idioma,      " +
            "              id_vaga           " +
            "         FROM vge_idioma        " +
            "        where id_vaga = :idVaga ", nativeQuery = true)
    List<VgeIdiomaModel> findByIdVaga(@Param("idVaga") Integer idVaga);

    Boolean existsByIdIdioma(Integer idIdioma);
}