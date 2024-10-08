package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Reservation;
import com.etienne.cellier.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

  private final ReservationService reservationService;

  @Autowired
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping
  public List<Reservation> getAll() {
    return reservationService.getAll();
  }

  @GetMapping("/{id}")
  public Reservation getById(@PathVariable Long id) {
    return reservationService.getById(id);
  }

  @PostMapping
  public Reservation save(@RequestBody Reservation reservation) {
    return reservationService.save(reservation);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    reservationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
