package com.irrah.locadora.desafioLocadora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrah.locadora.desafioLocadora.models.AluguelCarro;
import com.irrah.locadora.desafioLocadora.models.Carro;
import com.irrah.locadora.desafioLocadora.models.Cliente;

public interface AluguelCarroRepository extends JpaRepository<AluguelCarro, Long>{
	AluguelCarro findByid(long id);

	List<AluguelCarro> findAllByCarro(Carro carro);

	List<AluguelCarro> findAllByCliente(Cliente cliente);
}
