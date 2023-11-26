package tn.esprit.tp1_aymen_nefzi_4twin7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Chambre;
import tn.esprit.tp1_aymen_nefzi_4twin7.entities.Reservation;

public interface IChambreRepository extends JpaRepository<Chambre , Long > {
//    @Query("select c from Chambre c where c.blocs.idBloc =:idbloc and c.typeC =:typeC")
//    List<Chambre> getChambreByBlocsAndTypeC (long idBloc , TypeChambre typeC);
//    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    Chambre findByReservationContains(Reservation reservation);
}







