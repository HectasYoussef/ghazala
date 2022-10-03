package com.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
