package br.com.varejo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@ManyToOne
	private Cliente cliente;
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido = new ArrayList<>();
	private LocalDate dataDoPedido;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	@Column(unique = true)
	private String numeroDoPedido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataDoPedido() {
		this.dataDoPedido = LocalDate.now();
		return dataDoPedido;
	}
	public BigDecimal getValorTotal() {
		calcularValorTotal();
		return valorTotal;
	}
	public String getNumeroDoPedido() {
		return numeroDoPedido;
	}
	public void setNumeroDoPedido(String numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}
	
	private void calcularValorTotal() {
		if(itensPedido.size() > 0) {
			for (ItemPedido itemPedido : itensPedido) {
				valorTotal.add(itemPedido.getSubTotal());
			}
		}
	}
}
