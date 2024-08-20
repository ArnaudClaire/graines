package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Sachet sachet;

    @NotNull
    @Positive
    private Integer quantite;

    @ManyToOne
    private Commande commande;

    // Constructeurs, getters et setters
    public LigneCommande() {
    }

    public LigneCommande(Long id, Sachet sachet, Integer quantite, Commande commande) {
        this.id = id;
        this.sachet = sachet;
        this.quantite = quantite;
        this.commande = commande;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sachet getSachet() {
        return sachet;
    }

    public void setSachet(Sachet sachet) {
        this.sachet = sachet;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", sachet=" + sachet +
                ", quantite=" + quantite +
                ", commande=" + commande +
                '}';
    }
}
