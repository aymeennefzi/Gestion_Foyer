package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Universite;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IFoyerRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IUniversiteRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoyerServicesImpl implements IFoyerService {

    final IFoyerRepository foyerRepository ;
    final IUniversiteRepository universiteRepository;
    @Override
    public Foyer ajouterFoyer(Foyer f) {return foyerRepository.save(f);}
    @Override
    public Foyer updatefoyer(Foyer f) {
        return foyerRepository.save(f);
    }
    @Override
    public void supprimer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }
    @Override
    public List<Foyer> getAllFoyer() {
        return (List<Foyer>)foyerRepository.findAll();
    }
    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite =universiteRepository.findById(idUniversite).orElse(null);
        Foyer foyer1 =foyerRepository.save(foyer);
        universite.setFoyer(foyer);
        foyerRepository.save(foyer);
        return foyer1;
    }
}
