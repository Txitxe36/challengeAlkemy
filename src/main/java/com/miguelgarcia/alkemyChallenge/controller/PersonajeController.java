package com.miguelgarcia.alkemyChallenge.controller;

import com.miguelgarcia.alkemyChallenge.DTO.PersonajeDTO;
import com.miguelgarcia.alkemyChallenge.Services.PersonajeService;
import com.miguelgarcia.alkemyChallenge.Services.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajes = personajeService.traerTodos();
        return ResponseEntity.ok().body(personajes);

    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> guardar(@RequestBody  PersonajeDTO personajeDTO){
        PersonajeDTO personajeGuardado= personajeService.guardar(personajeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personajeService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
