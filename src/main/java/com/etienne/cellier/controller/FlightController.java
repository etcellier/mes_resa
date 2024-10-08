package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Flight;
import com.etienne.cellier.service.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

  private final FlightService flightService;

  @Autowired
  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping
  public List<Flight> getAll() {
    return flightService.getAll();
  }

  @GetMapping("/{id}")
  public Flight getById(@PathVariable Long id) {
    return flightService.getById(id);
  }

  @PostMapping
  public Flight save(@RequestBody Flight flight) {
    return flightService.save(flight);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    flightService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
