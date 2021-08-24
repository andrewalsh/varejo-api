package br.com.varejo.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import br.com.varejo.filter.generics.FiltroAbstrato;
import br.com.varejo.filter.generics.Projection;
import br.com.varejo.filter.impl.strategy.ProjectionType;
import br.com.varejo.model.Cliente;

public class FiltroCliente implements FiltroAbstrato<Cliente>{
	
	public static final int PAGE = 1;
	public static final int LISTED = 2;
	
	private String cpfSelecionado;
	private int page = 0;
	private int size = 10;
	private int projectionStrategy;

	@Override
	public Selection[] configureProjection(CriteriaBuilder cb, Root<Cliente> root) {
		ProjectionType projectionType = ProjectionType.values()[projectionStrategy - 1];
		Projection<Cliente> projrction = projectionType.getProjectionType();
		return projrction.configureProjection(cb, root);
	}

	@Override
	public Predicate[] configureWhereClausule(CriteriaBuilder cb, Root<Cliente> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(Objects.nonNull(getCpfSelecionado())){
			predicates.add(cb.equal(root.get("cpf"), getCpfSelecionado()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public List<Order> orderBy(CriteriaBuilder cb, Root<Cliente> root) {
		List<Order> orderList = new ArrayList<>();
		return new ArrayList<>();
	}

	@Override
	public Expression<?>[] groupBy(CriteriaBuilder cb, Root<Cliente> root) {
		List<Expression<?>> expressions = new ArrayList<>();
		// TODO Auto-generated method stub
		return expressions.toArray(new Expression<?>[expressions.size()]);
	}

	public String getCpfSelecionado() {
		return cpfSelecionado;
	}

	public void setCpfSelecionado(String cpfSelecionado) {
		this.cpfSelecionado = cpfSelecionado;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getProjectionStrategy() {
		return projectionStrategy;
	}

	public void setProjectionStrategy(int projectionStrategy) {
		this.projectionStrategy = projectionStrategy;
	}
}
