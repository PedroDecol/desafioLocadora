package com.irrah.locadora.desafioLocadora.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_RESERVA")
public class ReservaCarro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//no pgAdmin colocar "ID INT GENERATED ALWAYS AS IDENTITY"
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false,unique = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_carro", nullable = false,unique = false)
	private Carro carro;
	
	public long getId_reserva() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
}