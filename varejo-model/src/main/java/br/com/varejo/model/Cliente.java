package br.com.varejo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	@Column(unique = true)
	private String cpf;
	private LocalDate nacimento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getNacimento() {
		return nacimento;
	}
	public void setNacimento(LocalDate nacimento) {
		if(idadeValida(nacimento))
			this.nacimento = nacimento;
	}
	
	private boolean idadeValida(LocalDate nascimento) {
		LocalDate hoje = LocalDate.now();
		long idade = ChronoUnit.YEARS.between(nascimento, hoje);
		
		if(idade <= 18)
			throw new RuntimeException("Cliente ainda não possui 18 anos");
		else
			return true;
	}
}
