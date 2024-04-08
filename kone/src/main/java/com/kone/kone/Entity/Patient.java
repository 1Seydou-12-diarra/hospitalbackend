package com.kone.kone.Entity;

import jakarta.persistence.*;

import java.util.Collection;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Entity
@Table(name = Patient.TABLE_NAME)
public class Patient {
    public static final String TABLE_NAME = "patient";

    public static final String TABLE_ID = TABLE_NAME + "_id";

    public static final String TABLE_SEQ = TABLE_ID + "_seq";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private  String email;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;
    public Patient(){}
    public Patient(Patient patient){}

    public Patient(String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.rendezVous = rendezVous;
    }
    public void mettreAJour(String nom) {

        if (!isBlank(nom)) {
            this.nom = nom;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Collection<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }
}
