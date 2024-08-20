package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String reference;

    @NotNull
    private LocalDateTime dateHeureDEnvoi;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesCommande;

    // Constructeurs
    public Commande() {
    }

    public Commande(Long id, String reference, LocalDateTime dateHeureDEnvoi, List<LigneCommande> lignesCommande) {
        this.id = id;
        this.reference = reference;
        this.dateHeureDEnvoi = dateHeureDEnvoi;
        this.lignesCommande = lignesCommande;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDateHeureDEnvoi() {
        return dateHeureDEnvoi;
    }

    public void setDateHeureDEnvoi(LocalDateTime dateHeureDEnvoi) {
        this.dateHeureDEnvoi = dateHeureDEnvoi;
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateHeureDEnvoi=" + dateHeureDEnvoi +
                ", lignesCommande=" + lignesCommande +
                '}';
    }
}
