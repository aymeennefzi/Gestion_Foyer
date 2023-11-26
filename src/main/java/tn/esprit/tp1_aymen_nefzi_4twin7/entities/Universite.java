package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long idUniversite ;

    @Column(name = "nomUniversite" , unique = true)
    String nomUniversite;

    String adresse ;

    @OneToOne
    @JoinColumn(name = "idFoyer")
    @JsonIgnore
    private Foyer foyer;
}
