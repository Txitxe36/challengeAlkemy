package com.miguelgarcia.alkemyChallenge.Services;

import com.miguelgarcia.alkemyChallenge.DTO.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    PersonajeDTO guardar(PersonajeDTO dto);

    List<PersonajeDTO> traerTodos();

    void borrar(Long id);
}
