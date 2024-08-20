package com.visiplus.graines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.visiplus.graines.model.Sachet;

import java.util.List;

@Repository
public interface SachetRepository extends JpaRepository<Sachet, Long> {
    @Query("SELECT s FROM Sachet s WHERE s.id NOT IN (SELECT l.sachet.id FROM LigneCommande l)")
    List<Sachet> findSachetsNotYetOrdered();

    @Query("SELECT s FROM Sachet s JOIN LigneCommande l ON s.id = l.sachet.id " +
            "GROUP BY s.id ORDER BY SUM(l.quantite) DESC")
    List<Sachet> findSachetsSortedByQuantityOrdered();
}
