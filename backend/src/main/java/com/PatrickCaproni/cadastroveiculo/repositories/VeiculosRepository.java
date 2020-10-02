package com.PatrickCaproni.cadastroveiculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PatrickCaproni.cadastroveiculo.entities.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

}
