package br.com.varejo.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.varejo.ClienteService;
import br.com.varejo.filter.FiltroCliente;
import br.com.varejo.generics.GenericResource;
import br.com.varejo.model.Cliente;
import br.com.varejo.model.dto.cliente.ClienteInsertDTO;
import br.com.varejo.model.dto.cliente.ClienteSummaryDTO;
import br.com.varejo.model.dto.cliente.ClienteUpdateDTO;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource extends GenericResource<Cliente, 
														ClienteSummaryDTO, 
														ClienteInsertDTO, 
														FiltroCliente, 
														ClienteUpdateDTO, 
														Integer>{
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteSummaryDTO> save(@RequestBody ClienteInsertDTO dto){
		ClienteSummaryDTO cliente = clienteService.save(dto);
		
		return ResponseEntity.created(uriNewResource(cliente.getId())).build();
	}

	
	@GetMapping
	public ResponseEntity<Page<ClienteSummaryDTO>> pagedList(
			@RequestParam(required = false) String cpf,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		
		FiltroCliente filtroCliente = new FiltroCliente();
		
		filtroCliente.setCpfSelecionado(cpf);
		filtroCliente.setPage(page);
		filtroCliente.setSize(size);
		
		return ResponseEntity.ok().body(clienteService.pagedList(filtroCliente));
	}

	
	
}
