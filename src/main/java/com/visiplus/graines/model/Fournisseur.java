package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Fournisseur extends Utilisateur {

    @Pattern(regexp = "^(06|07)\\d{8}$", message = "Le numéro de téléphone doit débuter par 06 ou 07")
    private String numeroDePortable;

    @OneToMany(mappedBy = "fournisseur")
    private List<Sachet> sachets;

    // Constructeurs
    public Fournisseur() {
    }

    public Fournisseur(Long id, String nom, String prenom, String adresseMail, String motDePasse,
            String numeroDePortable, List<Sachet> sachets) {
        super(id, nom, prenom, adresseMail, motDePasse);
        this.numeroDePortable = numeroDePortable;
        this.sachets = sachets;
    }

    // Getters et Setters
    public String getNumeroDePortable() {
        return numeroDePortable;
    }

    public void setNumeroDePortable(String numeroDePortable) {
        this.numeroDePortable = numeroDePortable;
    }

    public List<Sachet> getSachets() {
        return sachets;
    }

    public void setSachets(List<Sachet> sachets) {
        this.sachets = sachets;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", adresseMail='" + getAdresseMail() + '\'' +
                ", motDePasse='" + getMotDePasse() + '\'' +
                ", numeroDePortable='" + numeroDePortable + '\'' +
                ", sachets=" + sachets +
                '}';
    }
}
