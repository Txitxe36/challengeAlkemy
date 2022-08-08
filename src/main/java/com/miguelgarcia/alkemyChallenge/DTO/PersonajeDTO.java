package com.miguelgarcia.alkemyChallenge.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PersonajeDTO {

    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private Double peso;

    private String historia;

    //private List<Peliculas_SeriesEntity> peliculaOSerie ;
}
