package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Etudiant;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Reservation;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.TypeChambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IChambreRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IEtudiantRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IReservationRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReservationServiceImpl implements IReservationService{
    final IReservationRepository reservationRepository ;
    final IChambreRepository chambreRepository;
    final IEtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>)reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cin) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

        Etudiant etudiant = etudiantRepository.findByCin(cin);

        // Création de la réservation
        Reservation reservation = new Reservation();
        assert chambre != null;
        reservation.setNumResrvation (chambre.getNumeroChambre() +"-"+ chambre.getBlocs().getNomBloc().replace(" ", "") +"-"+ cin);
        reservation.setDateDebut(LocalDate.of(LocalDate.now().getYear(), 9, 1));
        reservation.setDateFin(LocalDate.of(LocalDate.now().getYear() + 1, 6, 1));
        reservation.setEstValide(true);

        // Déterminer la capacité maximale en fonction du type de chambre
        int capaciteMax = 0;
        if (TypeChambre.SIMPLE.equals(chambre.getTypeC())) {
            capaciteMax = 1;
        } else if (TypeChambre.DOUBLE.equals(chambre.getTypeC())) {
            capaciteMax = 2;
        } else if (TypeChambre.TRIPLE.equals(chambre.getTypeC())) {
            capaciteMax = 3;
        }

        // Vérifier si la capacité maximale de la chambre est atteinte
        long nombreReservations = chambre.getReservation().size();
        if (nombreReservations >= capaciteMax) {
            throw new IllegalStateException("La capacité maximale de la chambre est atteinte.");
        }

        // Gérer la relation ManyToMany
        Set<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiant(etudiants);

        // Sauvegarder la réservation
        Reservation savedReservation = reservationRepository.save(reservation);

        // Ajouter la réservation à la collection de réservations de la chambre et sauvegarder
        chambre.getReservation().add(savedReservation);
        chambreRepository.save(chambre);

        return savedReservation;
    }
    @Transactional
    @Override
    public Reservation annulerReservation(long cin) {
        Etudiant etudiant = etudiantRepository.findByCin(cin);

        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiant().remove(etudiant);

        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssociee = chambreRepository.findByReservationContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservation().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }






}
