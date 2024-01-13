package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniversite;
    String nomUniversite;
    String adresse;

    @OneToOne(mappedBy="universite")
    Foyer foyer;
}
