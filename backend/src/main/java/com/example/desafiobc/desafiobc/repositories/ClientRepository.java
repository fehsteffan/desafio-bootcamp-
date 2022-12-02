package com.example.desafiobc.desafiobc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiobc.desafiobc.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}