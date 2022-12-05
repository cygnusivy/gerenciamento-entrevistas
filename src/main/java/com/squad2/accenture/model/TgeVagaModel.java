package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TGE_VAGA")
public class TgeVagaModel {

    @Id
    @Column(name = "ID_VAGA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVaga;

    @Column(name = "NOME_VAGA")
    @NotBlank(message = "Nome da vaga não informado")
    private String nomeVaga;

    @Column(name = "TEMP_ALOCACAO")
    @NotBlank(message = "Tempo de alocação não informado")
    private LocalDate tempoAlocacao;

    @Column(name = "ID_IDIOMA")
    @NotBlank(message = "idIdioma não informado")
    private Integer idIdioma;

    @Column
    @NotBlank(message = "Localidade não informada")
    private String localidade;

    @Column
    @NotBlank(message = "Descrição não informada")
    private String descricao;

}