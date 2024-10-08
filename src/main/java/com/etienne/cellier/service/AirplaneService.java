package com.etienne.cellier.service;

import com.etienne.cellier.entity.Airplane;
import com.etienne.cellier.repository.AirplaneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

  private final AirplaneRepository airplaneRepository;

  @Autowired
  public AirplaneService(AirplaneRepository airplaneRepository) {
    this.airplaneRepository = airplaneRepository;
  }

  public List<Airplane> getAll() {
    return airplaneRepository.findAll();
  }

  public Airplane getById(Long id) {
    return airplaneRepository.findById(id).orElse(null);
  }

  public Airplane save(Airplane airplane) {
    return airplaneRepository.save(airplane);
  }

  public void delete(Long id) {
    airplaneRepository.deleteById(id);
  }
}
