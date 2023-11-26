package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant extends User {

    @Column(unique = true) //CIN unique
    long cin ;

    String ecole ;

    @Temporal(TemporalType.DATE)
    LocalDate dateNaissance ;

    @JsonIgnore
    @ManyToMany (mappedBy="etudiant")
    Set<Reservation> reservations ;





}
