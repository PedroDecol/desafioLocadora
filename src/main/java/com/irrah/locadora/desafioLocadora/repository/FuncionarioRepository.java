package com.irrah.locadora.desafioLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrah.locadora.desafioLocadora.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	Funcionario findByid(long id);
}
