package com.visiplus.graines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.visiplus.graines.model.Commande;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateHeureDEnvoiBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT c FROM Commande c JOIN LigneCommande l ON c.id = l.commande " +
            "GROUP BY c.id ORDER BY SUM(l.quantite * l.sachet.prixEnEuros) DESC")
    List<Commande> findCommandesSortedByTotalAmount();
}
