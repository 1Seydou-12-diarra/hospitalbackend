package com.kone.kone.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kone.kone.Entity.Medecin;
import com.kone.kone.Entity.RendezVous;

import java.util.List;

public class MedecinDto {
    private Long id;
    private String nom;
    private String specialiste;
    private String email;

    @JsonIgnore
    private List<RendezVous> rendezVous;
    public  MedecinDto(){

    }

    public MedecinDto(Long id, String nom, String specialiste, String email, List<RendezVous> rendezVous) {
        this.id = id;
        this.nom = nom;
        this.specialiste = specialiste;
        this.email = email;
        this.rendezVous = rendezVous;
    }
    public MedecinDto(Medecin medecin){
        this.id= medecin.getId();
        this.nom = medecin.getNom();
        this.specialiste = medecin.getSpecialiste();
        this.email = medecin.getEmail();
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

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }
}

