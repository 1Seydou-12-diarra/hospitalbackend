package com.kone.kone.Repository;

import com.kone.kone.Entity.Medecin;
import com.kone.kone.Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RendezVousRepository  extends JpaRepository<RendezVous,Long> {
    Optional<RendezVous> findByMedecin(Medecin medecin);
}






