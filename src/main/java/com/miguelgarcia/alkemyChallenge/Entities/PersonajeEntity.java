package com.miguelgarcia.alkemyChallenge.Entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter @Setter
@SQLDelete(sql = "UPDATE Personaje SET deleted= true WHERE=id=?")
//con esto quedan diferenciados los que fueron borrados de los que no
@Where(clause = "deleted=false")
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private Double peso;

    private String historia;

    private boolean deleted= Boolean.FALSE;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<Peliculas_SeriesEntity> peliculaOSerie = new ArrayList<>();

    //redefiniendo la comparacion de personajes.
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final PersonajeEntity other = (PersonajeEntity) obj;
        return other.id == this.id;
    }

    //agregar y remover pelicula o serie
    //public void addPelicula(Peliculas_SeriesEntity pelicula){this.peliculaOSerie.add(pelicula);}

    public void removePelicula(Peliculas_SeriesEntity pelicula){this.peliculaOSerie.remove(pelicula);}
}
