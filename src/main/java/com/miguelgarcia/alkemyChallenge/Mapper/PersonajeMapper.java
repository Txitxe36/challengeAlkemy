package com.miguelgarcia.alkemyChallenge.Mapper;

import com.miguelgarcia.alkemyChallenge.DTO.Peliculas_SeriesDTO;
import com.miguelgarcia.alkemyChallenge.DTO.PersonajeDTO;
import com.miguelgarcia.alkemyChallenge.Entities.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    @Autowired
    private Peliculas_SeriesMapper peliculas_seriesMapper;

    //recibe un dto y devuelve una entidad
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
    PersonajeEntity personajeEntity= new PersonajeEntity();
    personajeEntity.setImagen(dto.getImagen());
    personajeEntity.setNombre(dto.getNombre());
    personajeEntity.setEdad(dto.getEdad());
    personajeEntity.setPeso(dto.getPeso());
    personajeEntity.setHistoria(dto.getHistoria());

    return personajeEntity;
    }

    //cuando llega una entidad hay que devolver el ID de esa entidad al cliente
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPelicula){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        if(loadPelicula){
            List<Peliculas_SeriesDTO>peliculas_seriesDTOS= this.peliculas_seriesMapper.peliculasEntityList2DTOList(entity.getPeliculaOSerie(),loadPelicula:false);
        }
        return dto;
    }

    //recibe una lista de entidades y las pasa a una lista de dtos
    public List<PersonajeDTO> personajeEntityList2DTOList(List<PersonajeEntity> entities){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities){
            dtos.add(personajeEntity2DTO(entity));
        }
        return dtos;

    }
}
