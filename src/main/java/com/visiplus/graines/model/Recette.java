package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

import io.micrometer.common.lang.NonNull;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotBlank
    private String intitule;

    @Size(min = 40, message = "Le contenu doit contenir au minimum 40 caractères")
    private String contenu;

    @ManyToMany(mappedBy = "recettes")
    private List<TypeDeGraine> typeDeGraines;

    @ManyToOne
    private Jardinier jardinier;

    // Constructeurs
    public Recette() {
    }

    public Recette(Long id, String intitule, String contenu, List<TypeDeGraine> typeDeGraines, Jardinier jardinier) {
        this.id = id;
        this.intitule = intitule;
        this.contenu = contenu;
        this.typeDeGraines = typeDeGraines;
        this.jardinier = jardinier;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<TypeDeGraine> getTypeDeGraines() {
        return typeDeGraines;
    }

    public void setTypeDeGraines(List<TypeDeGraine> typeDeGraines) {
        this.typeDeGraines = typeDeGraines;
    }

    public Jardinier getJardinier() {
        return jardinier;
    }

    public void setJardinier(Jardinier jardinier) {
        this.jardinier = jardinier;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", contenu='" + contenu + '\'' +
                ", typeDeGraines=" + typeDeGraines +
                ", jardinier=" + jardinier +
                '}';
    }
}
