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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long idBloc;

    String nomBloc ;

    long capaciteBloc;

    @JsonIgnore
    @JoinColumn(name = "idFoyer")
    @ManyToOne
    Foyer foyer ;

    @OneToMany (mappedBy = "blocs" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE} , fetch = FetchType.EAGER)
    @JsonIgnore
    Set<Chambre> chambres ;



}
