package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.TypeChambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IChambreRepository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChambreServiceImpl implements IChambreService {
    final IChambreRepository chambreRepository ;

    @Override
    public List<Chambre> retrieveAllChambres() { //GETAll
        return (List<Chambre>)this.chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    } //post

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    } //PUT

    @Override
    public Chambre retrieveChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

//    @Override
//    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre type) {
//        return chambreRepository.findByBlocIdBlocAndTypeC (idBloc,type);
//    }
}
