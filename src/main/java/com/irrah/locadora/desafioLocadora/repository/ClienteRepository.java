package com.irrah.locadora.desafioLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrah.locadora.desafioLocadora.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByid(long id);
}
