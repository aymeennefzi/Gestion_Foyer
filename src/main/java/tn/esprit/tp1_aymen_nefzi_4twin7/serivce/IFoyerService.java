package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer ajouterFoyer (Foyer f);
    Foyer updatefoyer (Foyer f);
    void supprimer (long idFoyer);
    Foyer getFoyer (long idFoyer);
    List<Foyer> getAllFoyer();
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer ,long idUniversite);

}
