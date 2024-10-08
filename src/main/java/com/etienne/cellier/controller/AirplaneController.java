package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Airplane;
import com.etienne.cellier.service.AirplaneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

  private final AirplaneService airplaneService;

  @Autowired
  public AirplaneController(AirplaneService airplaneService) {
    this.airplaneService = airplaneService;
  }

  @GetMapping
  public List<Airplane> getAll() {
    return airplaneService.getAll();
  }

  @GetMapping("/{id}")
  public Airplane getById(Long id) {
    return airplaneService.getById(id);
  }

  @PostMapping
  public Airplane save(Airplane airplane) {
    return airplaneService.save(airplane);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(Long id) {
    airplaneService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
