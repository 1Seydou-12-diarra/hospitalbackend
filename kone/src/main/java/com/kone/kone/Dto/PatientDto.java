package com.kone.kone.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kone.kone.Entity.Patient;
import com.kone.kone.Entity.RendezVous;

import java.util.Collection;

public class PatientDto {
    private Long id;
    private String nom;
    private String email;

    @JsonIgnore
    private Collection<RendezVous> rendezVous;
    public  PatientDto(){
    }

    public PatientDto(Long id, String nom, String email, Collection<RendezVous> rendezVous) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.rendezVous = rendezVous;
    }

    public  PatientDto(Patient patient){
        this.id = patient.getId();
        this.nom = patient.getNom();
        this.email= patient.getEmail();

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

