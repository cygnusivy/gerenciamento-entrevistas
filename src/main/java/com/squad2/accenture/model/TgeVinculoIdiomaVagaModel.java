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
@Table(name = "TGE_VINCULO_IDIOMA_VAGA")
public class TgeVinculoIdiomaVagaModel {

    @Id
    @Column(name = "ID_VINCULO")
    private Integer idVinculo;

    @Column(name = "ID_IDIOMA")
    @NotBlank(message = "Campo idHabilidade não pode ser nulo!")
    private Integer idHabilidade;

    @Column(name = "ID_VAGA")
    @NotBlank(message = "Campo idVaga não pode ser nulo!")
    private Integer idVaga;

}