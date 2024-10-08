package com.etienne.cellier.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long flightId;

  @Column(nullable = false, unique = true)
  private String flightNumber;

  @Column(nullable = false)
  private Date departureDate;

  @Column(nullable = false)
  private String departureTime;

  @Column(nullable = false)
  private String arrivalTime;

  @Column(nullable = false)
  private String departureAirport;

  @Column(nullable = false)
  private String arrivalAirport;

  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  private Airplane airplane;

  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public void setArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
  }

  public Airplane getAirplane() {
    return airplane;
  }

  public void setAirplane(Airplane airplane) {
    this.airplane = airplane;
  }
}
