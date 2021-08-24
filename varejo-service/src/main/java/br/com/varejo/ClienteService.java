package br.com.varejo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.varejo.filter.FiltroCliente;
import br.com.varejo.generic.GenericService;
import br.com.varejo.model.Cliente;
import br.com.varejo.model.dto.cliente.ClienteInsertDTO;
import br.com.varejo.model.dto.cliente.ClienteSummaryDTO;
import br.com.varejo.model.dto.cliente.ClienteUpdateDTO;

@Service
public class ClienteService implements GenericService<Cliente, 
													  ClienteSummaryDTO, 
													  ClienteInsertDTO, 
													  FiltroCliente, 
													  ClienteUpdateDTO, 
													  Integer>{
	
	@PersistenceContext 
	private EntityManager em;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteRepositoryImpl clienteRepositoryImpl;

	@Override
	public ClienteSummaryDTO save(ClienteInsertDTO dto) {
		Query query = em.createQuery("SELECT count(c) FROM Cliente c WHERE c.cpf =:cpf");
		query.setParameter("cpf", dto.getCpf());
		boolean existeCPF = (Long) query.getSingleResult() > 0;
		
		if(existeCPF) {
			throw new RuntimeException("CPF "+ dto.getCpf()+" já está cadastrado");
		}
		
		return clienteEntityToSummary(clienteRepository.save(clienteInsertToCliente(dto)));
	}

	@Override
	public Page<ClienteSummaryDTO> pagedList(FiltroCliente filtro) {
		Pageable paginacao = PageRequest.of(filtro.getPage(), filtro.getSize());
		filtro.setProjectionStrategy(FiltroCliente.PAGE);
		return clienteRepositoryImpl.pagedList(filtro, paginacao);
	}

	@Override
	public void update(ClienteUpdateDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Cliente clienteInsertToCliente(ClienteInsertDTO dto) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Cliente cliente = new Cliente();
		
		cliente.setCpf(dto.getCpf());
		cliente.setNacimento(LocalDate.parse(dto.getNascimento(), dtf));
		cliente.setNome(dto.getNome());
		
		return cliente;
	}
	
	private ClienteSummaryDTO clienteEntityToSummary(Cliente cliente) {
		return new ClienteSummaryDTO(cliente.getId(), cliente.getNome());
	}
	
}
