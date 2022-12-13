package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TGE_ENTREVISTA")
public class TgeEntrevistaModel {

    @Id
    @Column(name = "ID_ENTREVISTA")
    private Integer idEntrevista;

    @Column(name = "DATA_ENTREVISTA")
    private LocalDate dataEntrevista;

    @Column(name = "CANDIDATO_CPF")
    private String candidatoCpf;

    @Column(name = "DESCR_HABILIDADES_TECNICAS")
    private String descHabilidadesTecnicas;

    @Column(name = "DESCR_HABILIDADES_INTERPESSOAL")
    private String descHabilidadesInterpessoais;

    @Column(name = "COD_STATUS")
    private String codStatus;
}