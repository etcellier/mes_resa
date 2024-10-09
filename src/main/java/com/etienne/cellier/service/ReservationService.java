package com.etienne.cellier.service;

import com.etienne.cellier.entity.Flight;
import com.etienne.cellier.entity.Passenger;
import com.etienne.cellier.entity.Reservation;
import com.etienne.cellier.repository.ReservationRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

  private final FlightService flightService;
  private final ReservationRepository reservationRepository;

  @Autowired
  public ReservationService(
      FlightService flightService, ReservationRepository reservationRepository) {
    this.flightService = flightService;
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

  public List<Reservation> getReservationsByFlight(Long flightId) {
    return reservationRepository.findAll().stream()
        .filter(reservation -> reservation.getFlight().getFlightId().equals(flightId))
        .collect(Collectors.toList());
  }

  public Integer getEmptySeatsByFlight(Long flightId) {
    Flight flight = flightService.getById(flightId);
    Integer totalSeats = flight.getAirplane().getCapacity();
    Integer reservedSeats = getReservationsByFlight(flightId).size();
    return totalSeats - reservedSeats;
  }

  public Map<String, List<Passenger>> getCategorizedPassengersByFlight(Long flightId) {
    List<Reservation> reservations = getReservationsByFlight(flightId);
    return categorizePassengers(reservations);
  }

  public Map<String, Integer> countCategorizedPassengersByFlight(Long flightId) {
    List<Reservation> reservations = getReservationsByFlight(flightId);
    return categorizePassengers(reservations).entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }

  private Map<String, List<Passenger>> categorizePassengers(List<Reservation> reservations) {
    return reservations.stream()
        .map(Reservation::getPassenger)
        .collect(
            Collectors.groupingBy(
                passenger -> categorizePassenger(passenger, reservations.getFirst().getFlight())));
  }

  public String categorizePassenger(Passenger passenger, Flight flight) {
    long ageInMillis = flight.getDepartureDate().getTime() - passenger.getBirthdate().getTime();
    long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);

    if (ageInYears < 2) {
      return "Baby";
    } else if (ageInYears < 12) {
      return "Child";
    } else {
      return "Adult";
    }
  }
}
