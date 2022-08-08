package com.miguelgarcia.alkemyChallenge.DTO;

import com.miguelgarcia.alkemyChallenge.Entities.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Peliculas_SeriesDTO {

    private Long id;

    private String image;

    private String titulo;

    private LocalDate fechaDeCreacion;

    private Integer calificacion;

    private List<PersonajeEntity> personajes=new ArrayList<>();
}
