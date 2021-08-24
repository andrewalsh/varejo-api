package br.com.varejo.model.dto.itempedido;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPedidoSummaryDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer itemPedidoId;
	private String descricaoProduto;
	private Integer quantidade;
	private BigDecimal subTotal;
	
	public ItemPedidoSummaryDTO(Integer itemPedidoId, String descricaoProduto, Integer quantidade, BigDecimal subTotal) {
		this.itemPedidoId = itemPedidoId;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.subTotal = subTotal;
	}

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}
}
