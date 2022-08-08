package com.miguelgarcia.alkemyChallenge.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Table(name = "pelicula_serie")
@Getter
@Setter
@SQLDelete(sql="UPDATE Pelicula_serie SET deleted = true WHERE id=?")
@Where(clause ="deleted=false")
@Entity
public class Peliculas_SeriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;

    private Integer calificacion;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "personajePelicula",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id"))
    private List<PersonajeEntity> personajes=new ArrayList<>();
}
