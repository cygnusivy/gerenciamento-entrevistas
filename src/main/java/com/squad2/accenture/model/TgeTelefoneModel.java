package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TGE_TELEFONE")
public class TgeTelefoneModel {

    @Id
    @Column(name = "ID_TELEFONE")
    private Integer idTelefone;

    @Column(name = "CANDIDATO_CPF")
    @NotBlank(message = "Campo candidatoCpf não pode ser nulo")
    private String candidatoCpf;

    @Column
    @NotBlank(message = "Campo numero não pode ser nulo")
    private String numero;
}
