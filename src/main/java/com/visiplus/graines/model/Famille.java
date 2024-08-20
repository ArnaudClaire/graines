package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Famille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 6, max = 6, message = "La couleurRGB doit contenir exactement 6 caractères")
    private String couleurRGB;

    @NotBlank
    private String nom;

    // Constructeurs, getters et setters
    public Famille() {
    }

    public Famille(Long id, String couleurRGB, String nom) {
        this.id = id;
        this.couleurRGB = couleurRGB;
        this.nom = nom;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcouleurRGB() {
        return couleurRGB;
    }

    public void setcouleurRGB(String couleurRGB) {
        this.couleurRGB = couleurRGB;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Famille{" +
                "id=" + id +
                ", couleurRGB='" + couleurRGB + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
