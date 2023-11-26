package tn.esprit.tp1_aymen_nefzi_4twin7.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.TypeChambre;

import java.util.List;

public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
    Foyer findByNomFoyer (String nom);
    @Query("select f from Foyer f join f.blocs b JOIN b.chambres ch where ch.typeC= :typec")
    List<Foyer> getFoyerByTypeChambre (@Param("typec") TypeChambre typec);
}
