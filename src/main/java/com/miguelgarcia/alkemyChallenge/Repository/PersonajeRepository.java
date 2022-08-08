package com.miguelgarcia.alkemyChallenge.Repository;

import com.miguelgarcia.alkemyChallenge.Entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long> {


}
