package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c );

    Chambre retrieveChambreById (long idChambre);

//    List<Chambre> getChambresParBlocEtType( long idBloc,TypeChambre type) ;
}
