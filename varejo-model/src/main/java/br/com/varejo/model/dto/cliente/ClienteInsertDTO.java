package br.com.varejo.model.dto.cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String nascimento;
	
	public ClienteInsertDTO(String nome, String cpf, String nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNascimento() {
		return nascimento;
	}
}
