package com.kone.kone.Dto;

import com.kone.kone.Entity.Consultation;

import java.util.Date;

public class ConsultationDto {
    private Long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private double prixConsultation;
    public  ConsultationDto(){}
    public ConsultationDto(Long id, Date dateConsultation, String rapportConsultation, double prixConsultation) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.rapportConsultation = rapportConsultation;
        this.prixConsultation = prixConsultation;
    }
    public ConsultationDto(Consultation consultation){
        this.id = consultation.getId();
        this.dateConsultation = consultation.getDateConsultation();
        this.rapportConsultation = consultation.getRapportConsultation();
        this.prixConsultation = consultation.getPrixConsultation();
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
