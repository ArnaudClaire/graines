package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Graine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @ManyToOne
    private Famille famille;

    // Constructeurs, getters et setters
    public Graine() {
    }

    public Graine(Long id, String nom, Famille famille) {
        this.id = id;
        this.nom = nom;
        this.famille = famille;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    @Override
    public String toString() {
        return "Graine{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", famille=" + famille +
                '}';
    }
}
