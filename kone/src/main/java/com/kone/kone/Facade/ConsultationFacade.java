
package com.kone.kone.Facade;
import com.kone.kone.Dto.ConsultationDto;
import com.kone.kone.Dto.MedecinDto;
import com.kone.kone.Entity.Consultation;
import com.kone.kone.Entity.Medecin;
import com.kone.kone.Repository.ConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationFacade {

    private final ConsultationRepository consultationRepository;

    public ConsultationFacade(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<ConsultationDto> listerConsultations() {
        List<Consultation> consultations = consultationRepository.findAll();
        return consultations.stream().map(ConsultationDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void enregistrerOuModifierConsultation(ConsultationDto consultationDto) {
        Consultation consultation = consultationRepository.findByRapportConsultation(consultationDto.getRapportConsultation().trim()).orElse(null);
        if (consultation == null) {
            consultation = new Consultation(consultationDto.getDateConsultation(),consultationDto.getRapportConsultation(),consultationDto.getPrixConsultation());
        } else {
            // Ajoutez ici la logique pour mettre à jour le médecin si nécessaire
        }
        consultationRepository.save(consultation);
    }


    @Transactional
    public void supprimerConsultation(Long consultationId) {
        consultationRepository.deleteById(consultationId);
    }
}
