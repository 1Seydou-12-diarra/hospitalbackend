package com.kone.kone.Facade;

import com.kone.kone.Dto.RendezVousDto;
import com.kone.kone.Entity.RendezVous;
import com.kone.kone.Repository.RendezVousRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class RendezVousFacade {
    private final RendezVousRepository rendezVousRepository;

    public RendezVousFacade(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public List<RendezVousDto> listerRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return rendezVousList.stream().map(RendezVousDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void enregistrerOuModifierRendezVous(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = new RendezVous();

    }

    @Transactional
    public void supprimerRendezVous(Long rendezVousId) {
        rendezVousRepository.deleteById(rendezVousId);
    }
}

