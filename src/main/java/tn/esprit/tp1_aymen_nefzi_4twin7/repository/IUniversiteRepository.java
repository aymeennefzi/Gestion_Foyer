package tn.esprit.tp1_aymen_nefzi_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Universite;

public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite (String nomUniv);
}
