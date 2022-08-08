package com.miguelgarcia.alkemyChallenge.Services;

import com.miguelgarcia.alkemyChallenge.DTO.Peliculas_SeriesDTO;

import java.util.List;

public interface Peliculas_SeriesService {

    Peliculas_SeriesDTO save(Peliculas_SeriesDTO dto);

    List<Peliculas_SeriesDTO> getALlPeliculas();
}
