package com.kone.kone.Facade;

import com.kone.kone.Dto.PatientDto;
import com.kone.kone.Entity.Patient;
import com.kone.kone.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientFacade {
    private final PatientRepository patientRepository;

    public PatientFacade(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDto> listePatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientDto::new).collect(Collectors.toList());
    }
    @Transactional
    public void enregistrerOuModifier( PatientDto patientDto) {
        Patient patient = patientRepository.findByEmail(patientDto.getEmail().trim()).orElse(null);
        if (patient == null ){
            patient = new Patient( patientDto.getEmail(),patientDto.getNom());
        }else {
            patient.mettreAJour(patientDto.getNom());
        }
        patientRepository.save(patient);
    }


    @Transactional
    public void supprimerPatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
