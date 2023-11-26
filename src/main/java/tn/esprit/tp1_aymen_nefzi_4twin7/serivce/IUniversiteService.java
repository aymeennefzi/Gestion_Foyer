package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();

    Universite addUniversity (Universite u);

    Universite updateUniversity (Universite u);

    Universite retrieveUniversity (long idUniversity);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);

    public Universite desaffecterFoyerAUniversite ( long idUniversite) ;
}
