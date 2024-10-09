package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Passenger;
import com.etienne.cellier.entity.Reservation;
import com.etienne.cellier.service.ReservationService;
import java.util.List;
import java.util.Map;
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

  @GetMapping("/flight/{flightId}")
  public List<Reservation> getReservationsByFlight(@PathVariable Long flightId) {
    return reservationService.getReservationsByFlight(flightId);
  }

  @GetMapping("/flight/empty-seats/{flightId}")
  public Integer getEmptySeatsByFlight(@PathVariable Long flightId) {
    return reservationService.getEmptySeatsByFlight(flightId);
  }

  @GetMapping("/flight/passengers/{flightId}")
  public Map<String, List<Passenger>> getCategorizedPassengersByFlight(
      @PathVariable Long flightId) {
    return reservationService.getCategorizedPassengersByFlight(flightId);
  }

  @GetMapping("/flight/passengers/count/{flightId}")
  public Map<String, Integer> countCategorizedPassengersAndEmptySeatsByFlight(
      @PathVariable Long flightId) {
    Map<String, Integer> result = reservationService.countCategorizedPassengersByFlight(flightId);
    result.put("emptySeats", reservationService.getEmptySeatsByFlight(flightId));
    return result;
  }
}
