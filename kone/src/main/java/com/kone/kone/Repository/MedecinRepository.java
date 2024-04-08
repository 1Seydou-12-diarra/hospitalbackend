package com.kone.kone.Repository;

import com.kone.kone.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    Optional<Medecin> findByEmail(String email);
}
