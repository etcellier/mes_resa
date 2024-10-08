package com.etienne.cellier.service;

import com.etienne.cellier.entity.Airplane;
import com.etienne.cellier.repository.AirplaneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Service pour gérer les opérations liées aux avions. */
@Service
public class AirplaneService {

  private final AirplaneRepository airplaneRepository;

  /**
   * Constructeur pour injecter le référentiel d'avions.
   *
   * @param airplaneRepository le référentiel d'avions
   */
  @Autowired
  public AirplaneService(AirplaneRepository airplaneRepository) {
    this.airplaneRepository = airplaneRepository;
  }

  /**
   * Récupère tous les avions.
   *
   * @return une liste de tous les avions
   */
  public List<Airplane> getAll() {
    return airplaneRepository.findAll();
  }

  /**
   * Récupère un avion par son identifiant.
   *
   * @param id l'identifiant de l'avion
   * @return l'avion correspondant à l'identifiant, ou null s'il n'existe pas
   */
  public Airplane getById(Long id) {
    return airplaneRepository.findById(id).orElse(null);
  }

  /**
   * Enregistre un nouvel avion ou met à jour un avion existant.
   *
   * @param airplane l'avion à enregistrer ou à mettre à jour
   * @return l'avion enregistré ou mis à jour
   */
  public Airplane save(Airplane airplane) {
    return airplaneRepository.save(airplane);
  }

  /**
   * Supprime un avion par son identifiant.
   *
   * @param id l'identifiant de l'avion à supprimer
   */
  public void delete(Long id) {
    airplaneRepository.deleteById(id);
  }
}
