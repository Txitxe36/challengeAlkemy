package com.miguelgarcia.alkemyChallenge.Repository;

import com.miguelgarcia.alkemyChallenge.Entities.Peliculas_SeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Peliculas_SeriesRepository extends JpaRepository<Peliculas_SeriesEntity,Long> {

}
