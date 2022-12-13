package com.squad2.accenture.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TGE_CANDIDATO")
public class TgeCandidatoModel {

    @Id
    @Column
    @NotBlank(message = "O campo de cpf não pode ser vazio")
    private String cpf;

    @Column
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @Column(name = "DESCRICAO_TECNICA")
    private String descricaoTecnica;

    @Column
    @NotBlank(message = "O campo de email naõ pode ser vazio")
    private String email;

    @Column(name = "PRETENCAO_SALARIO")
    private BigDecimal pretencaoSalario;

    @Column(name = "NOTA_INGLES")
    private BigDecimal notaIngles;

    @Column(name = "NOTA_LOGICA")
    private BigDecimal notaLogica;

    @Column(name = "NOTA_SQL")
    private BigDecimal notaSql;

    @Column(name = "ID_SENIORIDADE")
    private Integer idSenioridade;

    @Column(name = "COD_STATUS")
    private String codStatus;

    @Column(name = "VAGAS_ID_VAGA")
    private Integer vagasIdVaga;

}