package com.etienne.cellier.entity;

import jakarta.persistence.*;

@Entity
public class Airplane {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long airplaneId;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private int capacity;

  public Long getAirplaneId() {
    return airplaneId;
  }

  public void setAirplaneId(Long airplaneId) {
    this.airplaneId = airplaneId;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
