package com.irrah.locadora.desafioLocadora.resources;

import java.util.Calendar;
import java.util.Date;
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

import com.irrah.locadora.desafioLocadora.models.AluguelCarro;
import com.irrah.locadora.desafioLocadora.models.ReservaCarro;
import com.irrah.locadora.desafioLocadora.repository.AluguelCarroRepository;
import com.irrah.locadora.desafioLocadora.repository.CarroRepository;
import com.irrah.locadora.desafioLocadora.repository.ClienteRepository;
import com.irrah.locadora.desafioLocadora.repository.ReservaCarroRepository;

@RestController
@RequestMapping(value="/api")
public class AluguelCarroResource {

	@Autowired
	AluguelCarroRepository aluguelRepo;

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	CarroRepository carroRepo;

	@GetMapping("/aluguel")
	//retorna todos os alugueis
	public List<AluguelCarro> allAlueis(){
		List<AluguelCarro> allAlugueis = aluguelRepo.findAll();
		return allAlugueis;
	}

	@GetMapping("/aluguel/{id_cliente}")
	public List<AluguelCarro> allAlugueisSameCliente(@PathVariable(value = "id_cliente") long id_cliente){
		List<AluguelCarro> allAlugueis = aluguelRepo.findAllByCliente(clienteRepo.findByid(id_cliente));
		return allAlugueis;
	}

	@GetMapping("/aluguel/{id_veiculo}")
	public List<AluguelCarro> allAlugueisSameVeiculo(@PathVariable(value = "id_carro") long id_carro){

		List<AluguelCarro> allAlugueis = aluguelRepo.findAllByCarro(carroRepo.findByid(id_carro));
		return allAlugueis;
	}

	@GetMapping("/aluguel/{id}")
	public AluguelCarro getAluguel(@PathVariable(value = "id") long id){
		return aluguelRepo.findByid(id);
	}

	@PostMapping("/aluguel")
	public AluguelCarro saveAluguel(@RequestBody AluguelCarro aluguel){
		return aluguelRepo.save(aluguel);
	}

	@DeleteMapping("/aluguel")
	public void deleteAluguel(@RequestBody AluguelCarro aluguel){
		aluguelRepo.delete(aluguel);
	}

	@PutMapping("/aluguel")
	public AluguelCarro updateAluguel(@RequestBody AluguelCarro aluguel){
		return aluguelRepo.save(aluguel);
	}

}
