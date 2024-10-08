package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Passenger;
import com.etienne.cellier.service.PassengerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

  private final PassengerService passengerService;

  @Autowired
  public PassengerController(PassengerService passengerService) {
    this.passengerService = passengerService;
  }

  @GetMapping
  public List<Passenger> getAll() {
    return passengerService.getAll();
  }

  @GetMapping("/{id}")
  public Passenger getById(@PathVariable Long id) {
    return passengerService.getById(id);
  }

  @PostMapping
  public Passenger save(@RequestBody Passenger passenger) {
    return passengerService.save(passenger);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    passengerService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
