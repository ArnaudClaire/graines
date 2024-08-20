package com.visiplus.graines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.util.List;

@Entity
public class TypeDeGraine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @ManyToOne
    @NotNull
    private Famille famille;

    private String description;

    @Min(1)
    @Max(52)
    private Integer semaineDePlantationMin;

    @Min(1)
    @Max(52)
    private Integer semaineDePlantationMax;

    @Min(value = 0, message = "La quantité doit être supérieure ou égale à 0")
    private Integer espacementEntrePiedsEnCentimetres;

    @Min(value = 0, message = "La quantité doit être supérieure ou égale à 0")
    private Integer espacementEntreLignesEnCentimetres;

    @Size(min = 40, message = "Le conseil doit contenir au minimum 40 caractères")
    private String conseil;

    @ManyToMany(mappedBy = "typeDeGraines")
    private List<Recette> recettes;

    @OneToMany(mappedBy = "typeDeGraine")
    private List<Sachet> sachets;

    // Constructeurs, getters, setters, toString()...

    public TypeDeGraine() {
    }

    public TypeDeGraine(Long id, String nom, Famille famille, String description,
            Integer semaineDePlantationMin, Integer semaineDePlantationMax,
            Integer espacementEntrePiedsEnCentimetres, Integer espacementEntreLignesEnCentimetres,
            String conseil, List<Recette> recettes, List<Sachet> sachets) {
        this.id = id;
        this.nom = nom;
        this.famille = famille;
        this.description = description;
        this.semaineDePlantationMin = semaineDePlantationMin;
        this.semaineDePlantationMax = semaineDePlantationMax;
        this.espacementEntrePiedsEnCentimetres = espacementEntrePiedsEnCentimetres;
        this.espacementEntreLignesEnCentimetres = espacementEntreLignesEnCentimetres;
        this.conseil = conseil;
        this.recettes = recettes;
        this.sachets = sachets;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }

    public List<Sachet> getSachets() {
        return sachets;
    }

    public void setSachets(List<Sachet> sachets) {
        this.sachets = sachets;
    }

    @Override
    public String toString() {
        return "TypeDeGraine{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", famille=" + famille +
                ", description='" + description + '\'' +
                ", semaineDePlantationMin=" + semaineDePlantationMin +
                ", semaineDePlantationMax=" + semaineDePlantationMax +
                ", espacementEntrePiedsEnCentimetres=" + espacementEntrePiedsEnCentimetres +
                ", espacementEntreLignesEnCentimetres=" + espacementEntreLignesEnCentimetres +
                ", conseil='" + conseil + '\'' +
                ", recettes=" + recettes +
                ", sachets=" + sachets +
                '}';
    }
}
