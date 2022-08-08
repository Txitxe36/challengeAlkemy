package com.miguelgarcia.alkemyChallenge.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Getter @Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="pelicula_id",insertable = false,updatable = false)
    private Peliculas_SeriesEntity peliculaOSerie;

    @Column(name = "pelicula_id",nullable = false)
    private Long peliculaId;
}
