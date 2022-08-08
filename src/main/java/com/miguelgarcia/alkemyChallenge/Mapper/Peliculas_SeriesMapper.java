package com.miguelgarcia.alkemyChallenge.Mapper;

import com.miguelgarcia.alkemyChallenge.DTO.Peliculas_SeriesDTO;
import com.miguelgarcia.alkemyChallenge.Entities.Peliculas_SeriesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Peliculas_SeriesMapper {

    public Peliculas_SeriesEntity peliculasDto2Entity(Peliculas_SeriesDTO dto){
        Peliculas_SeriesEntity peliculas_seriesEntity = new Peliculas_SeriesEntity();
        peliculas_seriesEntity.setImage(dto.getImage());
        peliculas_seriesEntity.setTitulo(dto.getTitulo());
        peliculas_seriesEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculas_seriesEntity.setCalificacion(dto.getCalificacion());
        peliculas_seriesEntity.setPersonajes(dto.getPersonajes());

        return peliculas_seriesEntity;
    }


    public Peliculas_SeriesDTO peliculasEntity2DTO(Peliculas_SeriesEntity entity, boolean loadPersonaje){
        Peliculas_SeriesDTO dto= new Peliculas_SeriesDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaDeCreacion(entity.getFechaDeCreacion());
        dto.setCalificacion(entity.getCalificacion());
        dto.setPersonajes(entity.getPersonajes());

        return dto;
    }

    public List<Peliculas_SeriesDTO> peliculasEntityList2DTOList(List<Peliculas_SeriesEntity> entities,boolean loadPersonaje){
        List<Peliculas_SeriesDTO> dtos = new ArrayList<>();
        for (Peliculas_SeriesEntity entity:entities) {
            dtos.add(peliculasEntity2DTO(entity,loadPersonaje));
        }
        return dtos;
    }

}
