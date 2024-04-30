package com.example.testingsp.Repository;

import com.example.testingsp.Entite.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
