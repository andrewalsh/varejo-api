package br.com.varejo.model.dto.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.varejo.model.dto.itempedido.ItemPedidoSummaryDTO;

public class PedidoSummaryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer pedidoId;
	private BigDecimal valorTotal;
	private LocalDate dataDoPedido;
	private List<ItemPedidoSummaryDTO> itensPedidoSummaryDTO = new ArrayList<>();

}
