package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VGE_INFORMACOES_VAGA")
public class VgeInformacoesVagaModel {

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

    @Column
    @NotBlank(message = "Localidade não informada")
    private String localidade;

    @Column
    @NotBlank(message = "Descrição não informada")
    private String descricao;

}