package com.kone.kone.Repository;

import com.kone.kone.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

    Optional<Consultation> findByRapportConsultation(String rapportConsultation);
}
