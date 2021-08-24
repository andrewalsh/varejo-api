package br.com.varejo.filter.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import br.com.varejo.filter.generics.Projection;
import br.com.varejo.model.Cliente;

public class ProjectionListDTO implements Projection<Cliente>{

	@Override
	public Selection[] configureProjection(CriteriaBuilder cb, Root<Cliente> root) {
		List<Selection> selections = new ArrayList<>();
		
		selections.add(root.get("id"));
		selections.add(root.get("nome"));
		
		return selections.toArray(new Selection[selections.size()]);
	}

}
