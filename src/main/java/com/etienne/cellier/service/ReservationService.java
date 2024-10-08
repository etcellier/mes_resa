package com.etienne.cellier.service;

import com.etienne.cellier.entity.Reservation;
import com.etienne.cellier.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

  private final ReservationRepository reservationRepository;

  @Autowired
  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public List<Reservation> getAll() {
    return reservationRepository.findAll();
  }

  public Reservation getById(Long id) {
    return reservationRepository.findById(id).orElse(null);
  }

  public Reservation save(Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  public void delete(Long id) {
    reservationRepository.deleteById(id);
  }
}
