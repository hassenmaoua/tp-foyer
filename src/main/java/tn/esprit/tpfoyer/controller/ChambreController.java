package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.ChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    final ChambreService chambreService;

    @PostMapping
    public ResponseEntity<Chambre> createChambre(@RequestBody Chambre c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chambreService.addChambre(c));
    }

    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        List<Chambre> chambreList = chambreService.retrieveAllChambres();

        if (!chambreList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(chambreList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
