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
@Table(name = "TGE_STATUS")
public class TgeStatusModel {

    @Id
    @Column(name = "COD_STATUS")
    private String codStatus;

    @Column(name = "NOME_STATUS")
    @NotBlank(message = "Campo nomeStatus não pode ser nulo!")
    private String nomeStatus;
}
