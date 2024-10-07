package com.etienne.cellier.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/test-connection")
    public String testConnection() {
        try {
            entityManager.createNativeQuery("SELECT 1 FROM dual").getSingleResult();
            return "Connexion réussie à la base de données !";
        } catch (Exception e) {
            return "Erreur de connexion : " + e.getMessage();
        }
    }
}
