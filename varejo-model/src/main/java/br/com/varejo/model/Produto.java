package br.com.varejo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String semEstoque = "Produto Indisponível";
	
	@Id
	private Integer codigo;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private BigDecimal valor;
	@Column(nullable = false)
	private String situacao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		if(produtoComPrecoValido(valor))
			this.valor = valor;
		else {
			throw new RuntimeException("Produto deve possuir valor maior que zero");
		}
	}
	public String getSituacao() {
		if(this.quantidade > 0) {
			this.situacao = "";
		}
		else {
			this.situacao = semEstoque;
		}
		return situacao;
	}
	
	private boolean produtoComPrecoValido(BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO) <= 0)
			return false;
		else
			return true;
	}
}
