package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeVagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface TgeVagaRepository extends JpaRepository<TgeVagaModel, Integer> {

    @Query(value = "SELECT count(1)              " +
            "         from tge_vaga              " +
            "        where id_idioma = :idIdioma ", nativeQuery = true)
    Integer veriricaExistenciaIdioma(@PathVariable("idIdioma") Integer idIdioma);

    Boolean existsByNomeVaga(String nomeVaga);

    TgeVagaModel findByNomeVaga(String nomeVaga);
}
