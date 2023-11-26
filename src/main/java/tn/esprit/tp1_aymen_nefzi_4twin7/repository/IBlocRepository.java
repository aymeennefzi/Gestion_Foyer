package tn.esprit.tp1_aymen_nefzi_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Bloc;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;

import java.util.List;

public interface IBlocRepository extends CrudRepository<Bloc,Long> {
    Bloc findByNomBloc (String nom);
    List<Bloc> findByFoyer(Foyer foyer);

}
