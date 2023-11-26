package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer ;

    String nomFoyer;
    long capaciteFoyer ;

    @JsonIgnore
    @OneToOne (mappedBy ="foyer")
    Universite universite ;


    @OneToMany (mappedBy ="foyer" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE} , fetch = FetchType.EAGER)
    Set<Bloc> blocs;


}
