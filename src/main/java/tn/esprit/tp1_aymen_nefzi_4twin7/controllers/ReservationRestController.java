package tn.esprit.tp1_aymen_nefzi_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Reservation;
import tn.esprit.tp1_aymen_nefzi_4twin7.serivce.ReservationServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Service
@RequestMapping("/Reservation")
public class ReservationRestController {
    final ReservationServiceImpl reservationService ;


    @GetMapping("/GetAllReservation")
    public List<Reservation> retrieveAllR(){
        return this.reservationService.retrieveAllReservation();
    }
    @PutMapping("/updateReservation")
    public Reservation updateR(@RequestBody Reservation rese){
        return this.reservationService.updateReservation(rese);
    }
    @GetMapping("/GetReservationById/{id}")
    public Reservation retrieveR(@PathVariable("id") String idReservation){
        return this.reservationService.retrieveReservation(idReservation);
    }
    @PostMapping("/ajouterReservation/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable long idChambre, @PathVariable long cin) {
        return reservationService.ajouterReservation(idChambre,cin);
    }

    @PutMapping("/annulerReservation/{cin}")
    public Reservation annulerReservation(@PathVariable long cin) {
        return reservationService.annulerReservation(cin);
    }




    }
