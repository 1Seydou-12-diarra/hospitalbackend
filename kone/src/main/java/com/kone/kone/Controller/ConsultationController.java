
package com.kone.kone.Controller;
import com.kone.kone.Dto.ConsultationDto;
import com.kone.kone.Dto.MedecinDto;
import com.kone.kone.Facade.ConsultationFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationFacade consultationFacade;

    public ConsultationController(ConsultationFacade consultationFacade) {
        this.consultationFacade = consultationFacade;
    }

    @GetMapping("lister")
    public List<ConsultationDto> listConsultation() {
        return consultationFacade.listerConsultations();
    }

    @PostMapping("/enregistrer-ou-modifier")
    public ResponseEntity<String> enregistrerOuModifierConsultation(@RequestBody ConsultationDto consultationDto) {
        consultationFacade.enregistrerOuModifierConsultation(consultationDto);
        return new ResponseEntity<>("Consultation enregistrée/modifiée avec succès", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerConsultation(@PathVariable("id") Long consultationId) {
        consultationFacade.supprimerConsultation(consultationId);
        return new ResponseEntity<>("Consultation supprimée avec succès", HttpStatus.OK);
    }
}
