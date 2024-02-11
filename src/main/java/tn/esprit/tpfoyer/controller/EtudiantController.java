package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.etudiant.EtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    final EtudiantService etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(etudiantService.addEtudiant(c));
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiantList = etudiantService.retrieveAllEtudiants();

        if (!etudiantList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(etudiantList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(id);
        if (etudiant != null) {
            return ResponseEntity.status(HttpStatus.OK).body(etudiant);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant argEtudiant) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(argEtudiant.getIdEtudiant());
        if (etudiant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Etudiant updatedEtudiant = etudiantService.modifyEtudiant(argEtudiant);

        return ResponseEntity.status(HttpStatus.OK).body(updatedEtudiant);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEtudiant(@PathVariable Long id) {
        etudiantService.removeEtudiant(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
