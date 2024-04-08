package com.kone.kone.Facade;

import com.kone.kone.Dto.MedecinDto;
import com.kone.kone.Entity.Medecin;
import com.kone.kone.Repository.MedecinRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedecinFacade {

    private final MedecinRepository medecinRepository;

    public MedecinFacade(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public List<MedecinDto> listeMedecins() {
        List<Medecin> medecins = medecinRepository.findAll();
        return medecins.stream().map(MedecinDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void enregistrerOuModifier(MedecinDto medecinDto) {
        Medecin medecin = medecinRepository.findByEmail(medecinDto.getEmail().trim()).orElse(null);
        if (medecin == null) {
            medecin = new Medecin(medecinDto.getNom(), medecinDto.getSpecialiste(), medecinDto.getEmail());
        } else {
            // Ajoutez ici la logique pour mettre à jour le médecin si nécessaire
        }
        medecinRepository.save(medecin);
    }

    @Transactional
    public void supprimerMedecin(Long medecinId) {
        medecinRepository.deleteById(medecinId);
    }
}
