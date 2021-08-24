package br.com.varejo.generic;

import org.springframework.data.domain.Page;

/**
 * T  EntityClass
 * S  SmummaryClassDTO
 * I  InsertClassDTO
 * F  FilterClass
 * U  UpdateClassDTO
 * ID ID Class
 */

public interface GenericService<T, S, I, F, U, ID> {
	
	public S save(I dto);
	public Page<S> pagedList(F filtro);
	public void update(U dto);
	public void delete(ID id);
	public T findById(ID id);
}
