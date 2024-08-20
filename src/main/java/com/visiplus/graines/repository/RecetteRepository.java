package com.visiplus.graines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.visiplus.graines.model.Recette;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    @Query("SELECT r FROM Recette r JOIN r.typeDeGraines t GROUP BY r.id ORDER BY COUNT(t) DESC")
    List<Recette> findRecettesSortedByNumberOfTypesDeGraine();
}