package com.miguelgarcia.alkemyChallenge.controller;

import com.miguelgarcia.alkemyChallenge.DTO.Peliculas_SeriesDTO;
import com.miguelgarcia.alkemyChallenge.Services.Peliculas_SeriesService;
import com.miguelgarcia.alkemyChallenge.Services.Peliculas_SeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculas")
public class Peliculas_SeriesController {

    @Autowired
    private Peliculas_SeriesService peliculasSeriesService;

    //lista de peliculas
    @GetMapping("/all")
    public ResponseEntity<List<Peliculas_SeriesDTO>>getAll(){
        List<Peliculas_SeriesDTO> peliculas = peliculasSeriesService.getALlPeliculas();
        return ResponseEntity.ok().body(peliculas);
    }


    //guardar peliculas
    @PostMapping
    public ResponseEntity<Peliculas_SeriesDTO> save(@RequestBody Peliculas_SeriesDTO pelicula){
        //save pelicula
        Peliculas_SeriesDTO peliculaGuardada= peliculasSeriesService.save(pelicula);
        //201, pelicula guardada
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }
}
