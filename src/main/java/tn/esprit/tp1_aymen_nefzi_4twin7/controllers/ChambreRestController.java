package tn.esprit.tp1_aymen_nefzi_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.serivce.IChambreService;

import java.util.List;

@RequestMapping("/chambre")
@RestController
@RequiredArgsConstructor
public class ChambreRestController {
    private final IChambreService chambreService ;

    @GetMapping ("/GetAllChambre")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public List<Chambre> getallchambre (){
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return this.chambreService.addChambre(chambre);
    }

    @GetMapping("/getChambre/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public Chambre getchambre(@PathVariable("id") long id) {
        return this.chambreService.retrieveChambreById(id);
    }

    @PutMapping ("/Update")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Chambre upadteCh (@RequestBody Chambre chambre){
        return this.chambreService.updateChambre(chambre);
    }


//    @GetMapping("getChambresParBlocEtType/{idBloc}/{type}")
//    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeChambre type) {
//        return chambreService.getChambresParBlocEtType(idBloc,type);
//    }

}

