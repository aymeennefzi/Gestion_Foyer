package tn.esprit.tp1_aymen_nefzi_4twin7.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class User implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id ;
    String nom ;
    String prenom ;
    @Column(unique = true)
    String email ;
    String password ;
    @Enumerated(EnumType.STRING)
    Erole role ;


}
