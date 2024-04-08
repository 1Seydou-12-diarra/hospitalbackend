package com.kone.kone.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.kone.Entity.Consultation;
import com.kone.kone.Entity.Medecin;
import com.kone.kone.Entity.Patient;
import com.kone.kone.Entity.RendezVous;

import java.util.Date;

public class RendezVousDto {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateRendezVous;

    private Patient patient;

    private Medecin medecin;

    private Consultation consultation;

    public  RendezVousDto(){}

    public RendezVousDto(Long id, Date dateRendezVous, Patient patient, Medecin medecin, Consultation consultation) {
        this.id = id;
        this.dateRendezVous = dateRendezVous;
        this.patient = patient;
        this.medecin = medecin;
        this.consultation = consultation;
    }

    public RendezVousDto(RendezVous rendezVous) {
        this.id = id;
        this.dateRendezVous = dateRendezVous;

        this.medecin = new Medecin(rendezVous.getMedecin());
        this.patient = new Patient(rendezVous.getPatient());
        this.consultation = new Consultation(rendezVous.getConsultation());
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
