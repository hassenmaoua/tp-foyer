package tn.esprit.tpfoyer.service.reservation;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService{
    public List<Reservation> retrieveAllReservations();

    public Reservation retrieveReservation(String reservationId);

    public Reservation addReservation(Reservation c);

    public void removeReservation(String reservationId);

    public Reservation modifyReservation(Reservation reservation);
}
