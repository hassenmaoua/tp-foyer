package tn.esprit.tpfoyer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    String idReservation;
    Date anneeUniversitaire;
    boolean estValide;

    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;
}
