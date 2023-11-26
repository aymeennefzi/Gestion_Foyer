package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long idChambre;

    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC ;

    @ManyToOne
    @JoinColumn(name = "idBloc")
    private Bloc blocs ;

    @OneToMany
    Set<Reservation> reservation ;
    }

