package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Etudiant;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IEtudiantRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements IEtudiantService {

    final IEtudiantRepository etudiantRepository ;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {return (List<Etudiant>) etudiantRepository.findAll();}
    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }
    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public Etudiant AddEtudiant(Etudiant e) {
        return this.etudiantRepository.save(e);
    }
}

