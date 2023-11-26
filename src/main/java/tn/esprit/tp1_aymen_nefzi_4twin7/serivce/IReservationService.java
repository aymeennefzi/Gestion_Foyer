package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation updateReservation (Reservation res);
    List<Reservation> retrieveAllReservation();
    Reservation retrieveReservation (String idReservation);

    public Reservation ajouterReservation(long idChambre, long cin);
    public Reservation annulerReservation(long cin);
}
