package com.etienne.cellier.service;

import com.etienne.cellier.entity.Flight;
import com.etienne.cellier.repository.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

  private final FlightRepository flightRepository;

  @Autowired
  public FlightService(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  public List<Flight> getAll() {
    return flightRepository.findAll();
  }

  public Flight getById(Long id) {
    return flightRepository.findById(id).orElse(null);
  }

  public Flight save(Flight flight) {
    return flightRepository.save(flight);
  }

  public void delete(Long id) {
    flightRepository.deleteById(id);
  }
}
