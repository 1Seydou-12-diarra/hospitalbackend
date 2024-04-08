package com.kone.kone.Controller;

import com.kone.kone.Dto.PatientDto;
import com.kone.kone.Facade.PatientFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientFacade patientFacade;

    public PatientController(PatientFacade patientFacade) {
        this.patientFacade = patientFacade;
    }

    @GetMapping("lister")
    public List<PatientDto> listePatients() {
        return patientFacade.listePatient();
    }
    @PostMapping("/enregistrer-ou-modifier")
    public ResponseEntity<String> enregistrerOuModifierPatient(@RequestBody PatientDto patientDto) {
        patientFacade.enregistrerOuModifier(patientDto);
        return new ResponseEntity<>("Patient enregistré/modifié avec succès", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerPatient(@PathVariable("id") Long patientId) {
        patientFacade.supprimerPatient(patientId);
        return new ResponseEntity<>("Patient supprimé avec succès", HttpStatus.OK);
    }
}

