package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Sachet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "Le poids en grammes doit être positif ou nul")
    @NotNull
    private Integer poidsEnGramme;

    @PositiveOrZero(message = "Le prix en euros doit être positif ou nul")
    @NotNull
    private Double prixEnEuros;

    @OneToOne
    @NotNull
    private LigneCommande ligneCommande;

    @ManyToOne
    @NotNull
    private Fournisseur fournisseur;

    @ManyToOne
    @NotNull
    private TypeDeGraine typeDeGraine;

    // Constructeurs
    public Sachet() {
    }

    public Sachet(Long id, Integer poidsEnGramme, Double prixEnEuros, LigneCommande ligneCommande,
            Fournisseur fournisseur, TypeDeGraine typeDeGraine) {
        this.id = id;
        this.poidsEnGramme = poidsEnGramme;
        this.prixEnEuros = prixEnEuros;
        this.ligneCommande = ligneCommande;
        this.fournisseur = fournisseur;
        this.typeDeGraine = typeDeGraine;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoidsEnGramme() {
        return poidsEnGramme;
    }

    public void setPoidsEnGramme(Integer poidsEnGramme) {
        this.poidsEnGramme = poidsEnGramme;
    }

    public Double getPrixEnEuros() {
        return prixEnEuros;
    }

    public void setPrixEnEuros(Double prixEnEuros) {
        this.prixEnEuros = prixEnEuros;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public TypeDeGraine getTypeDeGraine() {
        return typeDeGraine;
    }

    public void setTypeDeGraine(TypeDeGraine typeDeGraine) {
        this.typeDeGraine = typeDeGraine;
    }

    @Override
    public String toString() {
        return "Sachet{" +
                "id=" + id +
                ", poidsEnGramme=" + poidsEnGramme +
                ", prixEnEuros=" + prixEnEuros +
                ", ligneCommande=" + ligneCommande +
                ", fournisseur=" + fournisseur +
                ", typeDeGraine=" + typeDeGraine +
                '}';
    }
}
