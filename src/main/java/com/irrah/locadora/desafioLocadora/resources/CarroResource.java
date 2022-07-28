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

import com.irrah.locadora.desafioLocadora.models.Carro;
import com.irrah.locadora.desafioLocadora.repository.CarroRepository;

@RestController
@RequestMapping(value="/api")
public class CarroResource {


	@Autowired
	CarroRepository carroRepo;

	@GetMapping("/carro")
	public List<Carro> listaCarros(){
		return carroRepo.findAll();
	}
	@GetMapping("/carro/{id}")
	public Carro listaCarrosUnico(@PathVariable(value="id") long id){
		return carroRepo.findByid(id);
	}
	@PostMapping("/carro")
	public Carro salvaCarro(@RequestBody Carro carro) {
		return carroRepo.save(carro);
	}

	@DeleteMapping("/carro")
	public void deletaCarro(@RequestBody Carro carro) {
		carroRepo.delete(carro);
	}

	@PutMapping("/carro")
	public Carro atualizaCarro(@RequestBody Carro carro) {
		return carroRepo.save(carro);
	}


}
