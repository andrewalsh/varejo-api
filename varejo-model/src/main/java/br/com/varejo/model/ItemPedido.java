package br.com.varejo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@ManyToOne
	private Produto produto;
	@Column(nullable = false)
	private int quantidade = 1;
	@Column(nullable = false)
	private BigDecimal subTotal;
	@ManyToOne
	private Pedido pedido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getSubTotal() {
		this.subTotal = produto.getValor().multiply(new BigDecimal(quantidade));
		return subTotal;
	}
	
	
	
}
