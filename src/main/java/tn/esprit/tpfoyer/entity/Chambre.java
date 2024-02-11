package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Block;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;
    Long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL)
    Set<Reservation> reservation;

    @ManyToOne
    Bloc bloc;
}