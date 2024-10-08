package com.etienne.cellier.controller;

import com.etienne.cellier.entity.Airplane;
import com.etienne.cellier.service.AirplaneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Contrôleur REST pour gérer les opérations liées aux avions. */
@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

  private final AirplaneService airplaneService;

  /**
   * Constructeur pour injecter le service des avions.
   *
   * @param airplaneService le service des avions
   */
  @Autowired
  public AirplaneController(AirplaneService airplaneService) {
    this.airplaneService = airplaneService;
  }

  /**
   * Récupère tous les avions.
   *
   * @return une liste de tous les avions
   */
  @GetMapping
  public List<Airplane> getAll() {
    return airplaneService.getAll();
  }

  /**
   * Récupère un avion par son identifiant.
   *
   * @param id l'identifiant de l'avion
   * @return l'avion correspondant à l'identifiant
   */
  @GetMapping("/{id}")
  public Airplane getById(@PathVariable Long id) {
    return airplaneService.getById(id);
  }

  /**
   * Enregistre un nouvel avion.
   *
   * @param airplane l'avion à enregistrer
   * @return l'avion enregistré
   */
  @PostMapping
  public Airplane save(@RequestBody Airplane airplane) {
    return airplaneService.save(airplane);
  }

  /**
   * Supprime un avion par son identifiant.
   *
   * @param id l'identifiant de l'avion à supprimer
   * @return une réponse sans contenu
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    airplaneService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
