package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Jardinier extends Utilisateur {

    @Past
    private LocalDate dateDeNaissance;

    @OneToMany(mappedBy = "jardinier")
    private List<Recette> recettes;

    // Constructeurs
    public Jardinier() {
    }

    public Jardinier(Long id, String nom, String prenom, String adresseMail, String motDePasse,
            LocalDate dateDeNaissance, List<Recette> recettes) {
        super(id, nom, prenom, adresseMail, motDePasse);
        this.dateDeNaissance = dateDeNaissance;
        this.recettes = recettes;
    }

    // Getters et Setters
    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }

    @Override
    public String toString() {
        return "Jardinier{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", adresseMail='" + getAdresseMail() + '\'' +
                ", motDePasse='" + getMotDePasse() + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", recettes=" + recettes +
                '}';
    }
}
