package Zoul.lalaina.BackEnd.model;

import jakarta.persistence.*;
@Entity
@Inheritance
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    @ManyToOne
    private Universite universite;

    public Etablissement() {
    }

    public Etablissement(int id, String nom, Universite universite) {
        this.id = id;
        this.nom = nom;
        this.universite = universite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
}
