package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.foyer.FoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    final FoyerService foyerService;

    @PostMapping
    public ResponseEntity<Foyer> createFoyer(@RequestBody Foyer c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foyerService.addFoyer(c));
    }

    @GetMapping
    public ResponseEntity<List<Foyer>> getAllFoyers() {
        List<Foyer> foyerList = foyerService.retrieveAllFoyers();

        if (!foyerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(foyerList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable Long id) {
        Foyer foyer = foyerService.retrieveFoyer(id);
        if (foyer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(foyer);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Foyer> updateFoyer(@RequestBody Foyer argFoyer) {
        Foyer foyer = foyerService.retrieveFoyer(argFoyer.getIdFoyer());
        if (foyer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Foyer updatedFoyer = foyerService.modifyFoyer(argFoyer);

        return ResponseEntity.status(HttpStatus.OK).body(updatedFoyer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteFoyer(@PathVariable Long id) {
        foyerService.removeFoyer(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
