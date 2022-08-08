package com.miguelgarcia.alkemyChallenge.Services;

import com.miguelgarcia.alkemyChallenge.DTO.Peliculas_SeriesDTO;
import com.miguelgarcia.alkemyChallenge.Entities.Peliculas_SeriesEntity;
import com.miguelgarcia.alkemyChallenge.Mapper.Peliculas_SeriesMapper;
import com.miguelgarcia.alkemyChallenge.Repository.Peliculas_SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Peliculas_SeriesServiceImpl implements Peliculas_SeriesService{


    @Autowired
    private Peliculas_SeriesMapper peliculas_seriesMapper;

    @Autowired
    private Peliculas_SeriesRepository peliculas_seriesRepository;


    public Peliculas_SeriesDTO save(Peliculas_SeriesDTO dto){
        Peliculas_SeriesEntity entity= peliculas_seriesMapper.peliculasDto2Entity(dto);
        Peliculas_SeriesEntity peliculaGuardada=  peliculas_seriesRepository.save(entity);
        Peliculas_SeriesDTO result = peliculas_seriesMapper.peliculasEntity2DTO(peliculaGuardada, loadPersonaje);

        return result;
    }

    @Override
    public List<Peliculas_SeriesDTO> getALlPeliculas() {
        List<Peliculas_SeriesEntity> entities = peliculas_seriesRepository.findAll();
        List<Peliculas_SeriesDTO> result= peliculas_seriesMapper.peliculasEntityList2DTOList(entities);
        return result;
    }


}
