package br.com.varejo.filter.impl.strategy;

import br.com.varejo.filter.generics.Projection;
import br.com.varejo.filter.impl.ProjectionPagedList;

public enum ProjectionType {

	PAGED_LIST {
		@Override
		public Projection getProjectionType() {
			return new ProjectionPagedList();
		}
	}, LIST_DTO {
		@Override
		public Projection getProjectionType() {
			return new ProjectionPagedList();
		}
	};
	
	public abstract Projection getProjectionType();
}
