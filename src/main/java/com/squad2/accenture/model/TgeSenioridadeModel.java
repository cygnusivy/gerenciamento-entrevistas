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
@Table(name = "TGE_SENIORIDADE")
public class TgeSenioridadeModel {

    @Id
    @Column(name = "ID_SENIORIDADE")
    private Integer idSenioridade;

    @Column(name = "NOME_SENIORIDADE")
    @NotBlank(message = "Campo senioridade não pode ser nulo!")
    private String senioridade;
}
