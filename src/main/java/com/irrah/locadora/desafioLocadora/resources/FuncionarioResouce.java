package com.irrah.locadora.desafioLocadora.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrah.locadora.desafioLocadora.models.Funcionario;
import com.irrah.locadora.desafioLocadora.repository.FuncionarioRepository;

@RestController
@RequestMapping(value="/api")
public class FuncionarioResouce {

	@Autowired
	FuncionarioRepository funcionarioRepo;
	
	@GetMapping("/funcionarios")
	public List<Funcionario> listaFuncionarios(){
		return funcionarioRepo.findAll();
	}
	
	@GetMapping("/funcionarios/{id}")
	public Funcionario listaFuncionarioUnico(@PathVariable(value="id") long id) {
		return funcionarioRepo.findByid(id);
	}
	
	@PostMapping("/funcionarios")
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepo.save(funcionario);
	}
	
	@DeleteMapping("/funcionarios")
	public void deletaFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepo.delete(funcionario);
	}
	
	@PutMapping("/funcionarios")
	public Funcionario atualizaFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepo.save(funcionario);
	}
}
