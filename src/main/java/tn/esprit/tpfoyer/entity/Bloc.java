package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;
    String nomBloc;
    Long capaciteBloc;

    @ManyToOne
    Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    List<Chambre> chambres;
}
