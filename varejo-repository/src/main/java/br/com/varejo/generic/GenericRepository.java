package br.com.varejo.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.varejo.filter.generics.FiltroAbstrato;

public interface GenericRepository<T, DTO> extends Serializable{
	Page<DTO> pagedList(FiltroAbstrato<T> filtroAbstrato, Pageable pageable);
	List<DTO> listDTO(FiltroAbstrato<T> filtroAbstrato);
}
