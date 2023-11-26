package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Bloc;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IBlocRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IChambreRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IFoyerRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
public class BlocServiceImpl implements IBlocService{
    final IBlocRepository blocRepository ;;
    final IChambreRepository chambreRepository ;
    final IFoyerRepository foyerRepository ;
    @Override
    public List<Bloc> retrieveBlocs() {
        return(List<Bloc>)blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
    @Override
    public Bloc affecterChambresABloc(List<Long> idChambre, long idBloc) {
        Bloc bloc =blocRepository.findById(idBloc).orElse(null);
        for (long id : idChambre){
            Chambre chambre=chambreRepository.findById(id).orElse(null);
            chambre.setBlocs(bloc);
            chambreRepository.save(chambre);
        }
        return blocRepository.save(bloc);
    }
    @Override
    public Bloc affecterBlocAFoyer(long idBloc, long idFoyer) {
        Bloc bloc =blocRepository.findById(idBloc).orElse(null);
        Foyer foyer=foyerRepository.findById(idFoyer).orElse(null);
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        return bloc ;
    }
}
