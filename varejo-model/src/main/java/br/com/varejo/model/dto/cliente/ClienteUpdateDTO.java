package br.com.varejo.model.dto.cliente;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteUpdateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private LocalDate nacimento;
	
	public ClienteUpdateDTO(Integer id, String nome, LocalDate nacimento) {
		this.id = id;
		this.nome = nome;
		this.nacimento = nacimento;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getNacimento() {
		return nacimento;
	}
}
