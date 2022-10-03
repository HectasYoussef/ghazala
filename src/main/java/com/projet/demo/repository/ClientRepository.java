package com.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
