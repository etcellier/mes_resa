package com.etienne.cellier.service;

import com.etienne.cellier.entity.Passenger;
import com.etienne.cellier.repository.PassengerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

  private final PassengerRepository passengerRepository;

  @Autowired
  public PassengerService(PassengerRepository passengerRepository) {
    this.passengerRepository = passengerRepository;
  }

  public List<Passenger> getAll() {
    return passengerRepository.findAll();
  }

  public Passenger getById(Long id) {
    return passengerRepository.findById(id).orElse(null);
  }

  public Passenger save(Passenger passenger) {
    return passengerRepository.save(passenger);
  }

  public void delete(Long id) {
    passengerRepository.deleteById(id);
  }
}
