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
@Table(name = "TGE_IDIOMA")
public class TgeIdiomaModel {

    @Id
    @Column(name = "id_idioma")
    @NotBlank(message = "Campo idIdioma não pode ser nulo")
    private Integer idIdioma;

    @Column(name = "nome_idioma")
    @NotBlank(message = "Campo idioma não pode ser nulo")
    private String idioma;

}