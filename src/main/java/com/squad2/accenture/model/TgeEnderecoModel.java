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
@Table(name = "TGE_ENDERECO")
public class TgeEnderecoModel {

    @Id
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @Column(name = "CANDIDATO_CPF")
    @NotBlank(message = "Campo candidatoCpf não pode ser nulo!")
    private String candidatoCpf;

    @Column
    @NotBlank(message = "Campo uf não pode ser nulo!")
    private String uf;

    @Column
    @NotBlank(message = "Campo cidade não pode ser nulo!")
    private String cidade;

    @Column
    @NotBlank(message = "Campo pais não pode ser nulo!")
    private String pais;

    @Column
    @NotBlank(message = "Campo bairro não pode ser nulo!")
    private String bairro;

    @Column
    @NotBlank(message = "Campo rua não pode ser nulo!")
    private String rua;

    @Column
    @NotBlank(message = "Campo numero não pode ser nulo!")
    private Integer numero;
}
