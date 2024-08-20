package com.visiplus.graines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visiplus.graines.model.Jardinier;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JardinierRepository extends JpaRepository<Jardinier, Long> {
    @Query("SELECT DISTINCT j FROM Jardinier j JOIN Commande c ON j.id = c.jardinier " +
            "JOIN LigneCommande lc ON c.id = lc.commande " +
            "JOIN Sachet s ON lc.sachet.id = s.id " +
            "JOIN TypeDeGraine t ON s.typeDeGraine.id = t.id " +
            "WHERE t.nom = 'Basilic'")
    List<Jardinier> findJardiniersWhoOrderedBasilic();

    @Query("SELECT j FROM Jardinier j JOIN Commande c ON j.id = c.jardinier " +
            "GROUP BY j.id ORDER BY COUNT(c) DESC")
    List<Jardinier> findJardiniersSortedByNumberOfOrders();

    @Query("SELECT j FROM Jardinier j WHERE j.dateDeNaissance <= :cutoffDate")
    List<Jardinier> findJardiniersOlderThan60(@Param("cutoffDate") LocalDate cutoffDate);
}
