package com.kone.kone.Controller;

import com.kone.kone.Dto.MedecinDto;
import com.kone.kone.Dto.PatientDto;
import com.kone.kone.Facade.MedecinFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecins")
public class MedecinController {

    private final MedecinFacade medecinFacade;

    public MedecinController(MedecinFacade medecinFacade) {
        this.medecinFacade = medecinFacade;
    }


    @GetMapping("lister")
    public List<MedecinDto> listMedecin() {
        return medecinFacade.listeMedecins();
    }

    @PostMapping("/enregistrer-ou-modifier")
    public ResponseEntity<String> enregistrerOuModifierMedecin(@RequestBody MedecinDto medecinDto) {
        medecinFacade.enregistrerOuModifier(medecinDto);
        return new ResponseEntity<>("Médecin enregistré/modifié avec succès", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMedecin(@PathVariable("id") Long medecinId) {
        medecinFacade.supprimerMedecin(medecinId);
        return new ResponseEntity<>("Médecin supprimé avec succès", HttpStatus.OK);
    }
}

