package tn.esprit.tp1_aymen_nefzi_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Universite;
import tn.esprit.tp1_aymen_nefzi_4twin7.serivce.UniversiteServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@Service
@RestController
@RequestMapping("/universite")
public class UniversiteRestController {
    private final UniversiteServiceImpl universiteService ;

    @GetMapping("/getAllUniversite")
    public List<Universite> retrieveAllU(){
        return this.universiteService.retrieveAllUniversities();
    }
    @PostMapping("/AddUniversite")
    public Universite addU(@RequestBody Universite uni){
        return universiteService.addUniversity(uni);
    }
    @PutMapping("/updateU")
    public Universite updateUn(Universite uni){
        return this.universiteService.updateUniversity(uni);
    }
    @GetMapping("/GetUniversiteById/{id}")
    public Universite retrieveU(@PathVariable("id") long id){
        return this.universiteService.retrieveUniversity(id);
    }

    @PutMapping("/affecterUniversiteAFoyer/{id}/{nom}")
    public Universite affecterFoyerAUniv(@PathVariable Long id, @PathVariable String nom){
        return this.universiteService.affecterFoyerAUniversite(id , nom);
    }
    @PutMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite (@PathVariable long idUniversite) {
        return this.universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

}
