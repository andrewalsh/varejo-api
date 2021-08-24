package br.com.varejo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.varejo.filter.generics.FiltroAbstrato;
import br.com.varejo.impl.GenericRepositoryImpl;
import br.com.varejo.model.Cliente;
import br.com.varejo.model.dto.cliente.ClienteSummaryDTO;

@Component
public class ClienteRepositoryImpl extends GenericRepositoryImpl<Cliente, ClienteSummaryDTO>{

	private static final long serialVersionUID = 1L;

	public ClienteRepositoryImpl() {
		super(Cliente.class, ClienteSummaryDTO.class);
	}

	@Override
	public Page<ClienteSummaryDTO> pagedList(FiltroAbstrato<Cliente> filtroAbstrato, Pageable pageable) {
		return super.pagedList(filtroAbstrato, pageable);
	}
}
