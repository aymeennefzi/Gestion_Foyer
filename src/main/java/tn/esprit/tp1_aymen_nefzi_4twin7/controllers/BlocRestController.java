package tn.esprit.tp1_aymen_nefzi_4twin7.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Bloc;
import tn.esprit.tp1_aymen_nefzi_4twin7.serivce.BlocServiceImpl;

import java.util.List;

@RequestMapping("/bloc")
@RestController
@RequiredArgsConstructor
@Tag(name="BLOC")
@CrossOrigin("*")
public class BlocRestController {
    public final BlocServiceImpl blocService ;

    @Operation(description = "retrieveAllBlocs")
    @GetMapping("/GetAllBlocs")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public List<Bloc> retrieveAllBlocs(){
        return blocService.retrieveBlocs();
    }

    @Operation(description = "Ajouter un bloc")
    @PostMapping("/AddBloc")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Bloc addbloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @Operation(description = "Update un bloc")
    @PutMapping("/updateBloc")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Bloc updatebloc(@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }

    @Operation(description = "Get Bloc (id)")
    @GetMapping("/getBlocById/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public Bloc retrieveCham( @PathVariable("id") long id){
        return blocService.retrieveBloc(id);
    }

    @Operation(description = "Supprimer un bloc(id)")
    @DeleteMapping("/RemoveBloc/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public void removeBloc(@PathVariable("id") long idBloc){
        blocService.removeBloc(idBloc);
    }

    @Operation(description = "Affecter un chambre a un bloc")
    @PostMapping("/affecterChambreABloc/{idBloc} ")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre,@PathVariable ("idBloc") long idBloc) {
        return blocService.affecterChambresABloc(numChambre , idBloc);
    }
    @Operation(description = "Affecter un bloc a un foyer")
    @PutMapping("/affecterBlocAFoyer/{idBloc}/{idFoyer}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public Bloc affecterBlocAFoyer(@PathVariable ("idBloc") long idBloc,@PathVariable ("idFoyer") long idFoyer){
        return blocService.affecterBlocAFoyer(idBloc,idFoyer);
    }

}

