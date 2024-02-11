package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.bloc.BlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    final BlocService blocService;

    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blocService.addBloc(c));
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocList = blocService.retrieveAllBlocs();

        if (!blocList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(blocList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.retrieveBloc(id);
        if (bloc != null) {
            return ResponseEntity.status(HttpStatus.OK).body(bloc);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Bloc> updateBloc(@RequestBody Bloc argBloc) {
        Bloc bloc = blocService.retrieveBloc(argBloc.getIdBloc());
        if (bloc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Bloc updatedBloc = blocService.modifyBloc(argBloc);

        return ResponseEntity.status(HttpStatus.OK).body(updatedBloc);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteBloc(@PathVariable Long id) {
        blocService.removeBloc(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
