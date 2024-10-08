package com.etienne.cellier.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long reservationId;

  @Column(nullable = false)
  private Date reservationDate;

  @ManyToOne
  @JoinColumn(name = "flight_id", nullable = false)
  private Flight flight;

  @ManyToOne
  @JoinColumn(name = "passenger_id", nullable = false)
  private Passenger passenger;

  @Column(nullable = false)
  private String seatNumber;

  public Long getReservationId() {
    return reservationId;
  }

  public void setReservationId(Long reservationId) {
    this.reservationId = reservationId;
  }

  public Date getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(Date reservationDate) {
    this.reservationDate = reservationDate;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }
}
