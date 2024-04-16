package Zoul.lalaina.BackEnd.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import java.sql.Blob;

@Entity
@Table(name = "universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniversite;
    @Column(name = "nom_univ")
    private String nomUniversite;
    @Column(name = "siege_univ")
    private String siegeUniversite;

    private byte[] image;


    public Universite(int idUniversite, String nomUniversite, String siegeUniversite, byte[] image) {
        this.idUniversite = idUniversite;
        this.nomUniversite = nomUniversite;
        this.siegeUniversite = siegeUniversite;
        this.image=image;

    }

    public Universite() {
    }

    public int getIdUniversite() {
        return idUniversite;
    }

    public void setIdUniversite(int idUniversite) {
        this.idUniversite = idUniversite;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }

    public String getSiegeUniversite() {
        return siegeUniversite;
    }

    public void setSiegeUniversite(String siegeUniversite) {
        this.siegeUniversite = siegeUniversite;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
