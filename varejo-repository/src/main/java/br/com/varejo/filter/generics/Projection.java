package br.com.varejo.filter.generics;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

public interface Projection <T>{

	Selection[] configureProjection(CriteriaBuilder cb, Root<T> root);
}
