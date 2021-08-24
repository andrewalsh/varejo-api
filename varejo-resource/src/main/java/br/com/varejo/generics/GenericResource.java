package br.com.varejo.generics;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.varejo.filter.FiltroCliente;


/**
 * T  EntityClass
 * S  SmummaryClassDTO
 * I  InsertClassDTO
 * F  FilterClass
 * U  UpdateClassDTO
 * ID ID Class
 */


public abstract class GenericResource<T, S, I, F, U, ID> {
	
	protected URI uriNewResource(Object id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(id).toUri();
		return uri;
	}

}
