package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.reservation.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(c));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservationList = reservationService.retrieveAllReservations();

        if (!reservationList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(reservationList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Reservation reservation = reservationService.retrieveReservation(id);
        if (reservation != null) {
            return ResponseEntity.status(HttpStatus.OK).body(reservation);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation argReservation) {
        Reservation reservation = reservationService.retrieveReservation(argReservation.getIdReservation());
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Reservation updatedReservation = reservationService.modifyReservation(argReservation);

        return ResponseEntity.status(HttpStatus.OK).body(updatedReservation);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteReservation(@PathVariable String id) {
        reservationService.removeReservation(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
