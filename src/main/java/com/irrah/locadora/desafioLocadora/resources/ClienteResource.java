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

import com.irrah.locadora.desafioLocadora.repository.ClienteRepository;
import com.irrah.locadora.desafioLocadora.models.*;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepo;

	@GetMapping("/cliente")
	public List<Cliente> listaClientes(){ 
		return clienteRepo.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Cliente listaClientesUnico(@PathVariable(value="id") long id){
		return clienteRepo.findByid(id);
	}

	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.save(cliente); 
	}

	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepo.delete(cliente);
	}
	@PutMapping("/cliente")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.save(cliente);
	}

}
