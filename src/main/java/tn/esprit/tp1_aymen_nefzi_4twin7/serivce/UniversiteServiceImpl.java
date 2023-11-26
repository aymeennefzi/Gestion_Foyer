package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Foyer;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Universite;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IFoyerRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IUniversiteRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UniversiteServiceImpl implements IUniversiteService {
    final IUniversiteRepository universiteRepository;
    final IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversity(long idUniversity) {
        return universiteRepository.findById(idUniversity).orElse(null);
    }

    //jsonIgnore : Ignore l'affichage de foyer sur la reponse json en postman
    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        //return universiteRepository.save(universite);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite( long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }
}
