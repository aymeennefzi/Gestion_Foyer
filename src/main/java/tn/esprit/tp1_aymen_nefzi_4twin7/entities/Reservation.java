package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    String numResrvation;

    String idReservation ;

    @Temporal(TemporalType.DATE)
    LocalDate dateDebut;

    @Temporal(TemporalType.DATE)
    LocalDate dateFin;

    boolean estValide ;

    @ManyToMany
    Set<Etudiant> etudiant ;


}
