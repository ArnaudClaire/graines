package com.visiplus.graines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visiplus.graines.model.TypeDeGraine;

import java.util.List;

@Repository
public interface TypeDeGraineRepository extends JpaRepository<TypeDeGraine, Long> {
    @Query("SELECT t FROM TypeDeGraine t WHERE t.semaineDePlantationMin <= :currentWeek " +
            "AND t.semaineDePlantationMax >= :currentWeek")
    List<TypeDeGraine> findTypesDeGrainePlantableToday(@Param("currentWeek") Integer currentWeek);
}
