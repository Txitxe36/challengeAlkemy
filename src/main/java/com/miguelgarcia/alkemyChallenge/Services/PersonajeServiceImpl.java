package com.miguelgarcia.alkemyChallenge.Services;

import com.miguelgarcia.alkemyChallenge.DTO.PersonajeDTO;
import com.miguelgarcia.alkemyChallenge.Entities.PersonajeEntity;
import com.miguelgarcia.alkemyChallenge.Mapper.PersonajeMapper;
import com.miguelgarcia.alkemyChallenge.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

        //guardar personaje y devolver personaje guardado
    public PersonajeDTO guardar(PersonajeDTO dto){
        //1er paso: convertir el dto en una entidad para poder guardarlo
        PersonajeEntity personajeEntity= personajeMapper.personajeDTO2Entity(dto);
        //guarda y devuelve la entidad guardada
        PersonajeEntity entitySaved= personajeRepository.save(personajeEntity);

        //tenemos que devolver un dto para el controller
        PersonajeDTO resultado= personajeMapper.personajeEntity2DTO(entitySaved);

        return resultado;
    }

    @Override
    public List<PersonajeDTO> traerTodos() {
        List<PersonajeEntity> entities= personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntityList2DTOList(entities);
        return result;
    }

    @Override
    public void borrar(Long id) {
        personajeRepository.deleteById(id);
    }

}
