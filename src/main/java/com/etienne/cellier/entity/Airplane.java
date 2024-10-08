package com.etienne.cellier.entity;

import jakarta.persistence.*;

/** Représente un avion dans le système. */
@Entity
public class Airplane {

  /** Identifiant unique de l'avion. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long airplaneId;

  /** Modèle de l'avion. */
  @Column(nullable = false)
  private String model;

  /** Capacité de l'avion (nombre de passagers). */
  @Column(nullable = false)
  private int capacity;

  /**
   * Obtient l'identifiant de l'avion.
   *
   * @return l'identifiant de l'avion
   */
  public Long getAirplaneId() {
    return airplaneId;
  }

  /**
   * Définit l'identifiant de l'avion.
   *
   * @param airplaneId l'identifiant de l'avion
   */
  public void setAirplaneId(Long airplaneId) {
    this.airplaneId = airplaneId;
  }

  /**
   * Obtient le modèle de l'avion.
   *
   * @return le modèle de l'avion
   */
  public String getModel() {
    return model;
  }

  /**
   * Définit le modèle de l'avion.
   *
   * @param model le modèle de l'avion
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * Obtient la capacité de l'avion.
   *
   * @return la capacité de l'avion
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Définit la capacité de l'avion.
   *
   * @param capacity la capacité de l'avion
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
