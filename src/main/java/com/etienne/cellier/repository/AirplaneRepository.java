package com.etienne.cellier.repository;

import com.etienne.cellier.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Référentiel pour les opérations CRUD sur les entités Airplane. */
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {}
