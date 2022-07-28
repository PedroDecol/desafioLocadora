package com.irrah.locadora.desafioLocadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrah.locadora.desafioLocadora.models.Carro;
import com.irrah.locadora.desafioLocadora.models.Cliente;
import com.irrah.locadora.desafioLocadora.models.ReservaCarro;

public interface ReservaCarroRepository extends JpaRepository<ReservaCarro, Long>{
	ReservaCarro findByid(long id);
	
	List<ReservaCarro> findAllByCarro(Carro carro);
	
	List<ReservaCarro> findAllByCliente(Cliente cliente);
}
