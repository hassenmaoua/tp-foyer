package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.universite.UniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    final UniversiteService universiteService;

    @PostMapping
    public ResponseEntity<Universite> createUniversite(@RequestBody Universite c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(universiteService.addUniversite(c));
    }

    @GetMapping
    public ResponseEntity<List<Universite>> getAllUniversites() {
        List<Universite> universiteList = universiteService.retrieveAllUniversites();

        if (!universiteList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(universiteList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        Universite universite = universiteService.retrieveUniversite(id);
        if (universite != null) {
            return ResponseEntity.status(HttpStatus.OK).body(universite);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Universite> updateUniversite(@RequestBody Universite argUniversite) {
        Universite universite = universiteService.retrieveUniversite(argUniversite.getIdUniversite());
        if (universite == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Universite updatedUniversite = universiteService.modifyUniversite(argUniversite);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUniversite);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUniversite(@PathVariable Long id) {
        universiteService.removeUniversite(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
