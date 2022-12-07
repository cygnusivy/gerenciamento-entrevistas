package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIdioma;

    @Column(name = "nome_idioma")
    @NotBlank(message = "Campo idioma não pode ser nulo")
    private String idioma;

}