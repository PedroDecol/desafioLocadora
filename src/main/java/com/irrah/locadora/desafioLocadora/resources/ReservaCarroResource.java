package com.irrah.locadora.desafioLocadora.resources;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ReservaCarroResource {

	@Autowired
	ReservaCarroRepository reservaRepo;

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	CarroRepository carroRepo;

	@GetMapping("/reservas")
	//Retorna todas as reservas
	public List<ReservaCarro> allReservas(){
		List<ReservaCarro> allReservas = reservaRepo.findAll();
		return allReservas;
	}

	@GetMapping("/reservas/{id_cliente}")
	//Retorna todas as reservas feitas por um cliente em específico
	public List<ReservaCarro> allReservaSameCliente(@PathVariable(value = "id_cliente") long id_cliente){
		List<ReservaCarro> allReservas = reservaRepo.findAllByCliente(clienteRepo.findByid(id_cliente));
		return allReservas;
	}

	@GetMapping("reservas/{id_veiculo}")
	//Retorna todas as reservas de um carro em específico
	public List<ReservaCarro> allReservasSameVeiculo(@PathVariable(value = "id_carro") long id_carro){
		List<ReservaCarro> allReservas = reservaRepo.findAllByCarro(carroRepo.findByid(id_carro));
		return allReservas;
	}

	@GetMapping("/reservas/{id}")
	//Retorna os dados de uma reserva
	public Optional<ReservaCarro> getReserva(@PathVariable(value = "id") long id){
		return reservaRepo.findById(id);
	}

	@PostMapping("/reservas")
	//Registra uma reserva
	public ReservaCarro saveReserva(@RequestBody ReservaCarro reserva, Long id_carro,Long id_cliente) {
		return reservaRepo.save(reserva);
		}
	}

