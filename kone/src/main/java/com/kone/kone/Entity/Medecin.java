package com.kone.kone.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Entity
@Table(name = Medecin.TABLE_NAME)
public class Medecin {
    public static final String TABLE_NAME ="medecin";

    public static final String TABLE_ID = TABLE_NAME + "_id";

    public static final String TABLE_SEQ = TABLE_ID + "_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String  nom;
    @Column(name ="specialiste" )
    private String specialiste;
    @Column(name ="email" )
    private String email;
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
    public  Medecin(Date dateConsultation, double prixConsultation, String rapportConsultation){}

    public Medecin(String nom, String specialiste, String email) {
        this.id = id;
        this.nom = nom;
        this.specialiste = specialiste;
        this.email = email;
        this.rendezVous = rendezVous;
    }

    public Medecin(Medecin medecin) {
    }
    public void mettreAJour(String nom, String specialiste ) {

        if (!isBlank(nom)) {
            this.nom = nom;
        }

        if (!isBlank(specialiste)) {
            this.specialiste = specialiste;
        }

    }

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

    public String getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }

    public String getEmail() {
        return email;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
