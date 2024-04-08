package com.kone.kone.Entity;

import jakarta.persistence.*;

import java.util.Date;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Entity
@Table(name = RendezVous.TABLE_NAME)
public class RendezVous {
    public static final String TABLE_NAME ="rendevVous";

    public static final String TABLE_ID = TABLE_NAME + "_id";

    public static final String TABLE_SEQ = TABLE_ID + "_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="dateRendezVous")
    private Date dateRendezVous;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private  Medecin medecin;
    @OneToOne
    private Consultation consultation;

    public  RendezVous(){

    }

    public RendezVous(Long id, Patient patient, Consultation consultation,Medecin medecin) {
        this.id = id;
        this.patient = patient;
        this.consultation = consultation;
        this.medecin =medecin;  }
    public void mettreAJour(Patient patient,Consultation consultation ) {

        if (!isBlank(String.valueOf(patient))) {
            this.patient = patient;
        }

        if (!isBlank(String.valueOf(consultation))) {
            this.consultation = consultation;
        }

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
