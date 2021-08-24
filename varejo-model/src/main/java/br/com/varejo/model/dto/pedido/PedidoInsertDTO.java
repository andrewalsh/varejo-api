package br.com.varejo.model.dto.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private List<Integer> itensPedidoId = new ArrayList<>();
	private LocalDate dataDoPedido;
	private BigDecimal valorTotal;
	
	public PedidoInsertDTO(Integer idCliente, List<Integer> itensPedidoId, LocalDate dataDoPedido, BigDecimal valorTotal) {
		this.idCliente = idCliente;
		this.itensPedidoId = itensPedidoId;
		this.dataDoPedido = dataDoPedido;
		this.valorTotal = valorTotal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public List<Integer> getItensPedidoId() {
		return itensPedidoId;
	}

	public LocalDate getDataDoPedido() {
		return dataDoPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
}
