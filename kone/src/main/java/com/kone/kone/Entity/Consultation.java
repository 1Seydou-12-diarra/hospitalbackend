package com.kone.kone.Entity;

import jakarta.persistence.*;

import java.util.Date;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Entity
@Table(name = Consultation.TABLE_NAME)
public class Consultation {
    public static final String TABLE_NAME ="consultation";

    public static final String TABLE_ID = TABLE_NAME + "_id";

    public static final String TABLE_SEQ = TABLE_ID + "_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dateConsultation")
    private Date dateConsultation;
    @Column(name="rapportConsultation")
    private  String rapportConsultation;
    @Column(name = "prixConsulttation")
    private double prixConsultation;
    @OneToOne(mappedBy = "consultation")
    private RendezVous rendezVous;
    public  Consultation(){}
    public Consultation(Consultation consultation) {

    }

    public Consultation(Date dateConsultation, String rapportConsultation, double prixConsultation) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.rapportConsultation = rapportConsultation;
        this.prixConsultation = prixConsultation;
    }

    public void mettreAJour(Date dateConsultation, Double prixConsultation ) {

        if (!isBlank(String.valueOf(dateConsultation))) {
            this.dateConsultation = dateConsultation;
        }

        if (!isBlank(String.valueOf(prixConsultation))) {
            this.prixConsultation = prixConsultation;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getRapportConsultation() {
        return rapportConsultation;
    }

    public void setRapportConsultation(String rapportConsultation) {
        this.rapportConsultation = rapportConsultation;
    }

    public double getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(double prixConsultation) {
        this.prixConsultation = prixConsultation;
    }
}
