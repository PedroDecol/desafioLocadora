package com.irrah.locadora.desafioLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrah.locadora.desafioLocadora.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	Carro findByid(long id);
}
