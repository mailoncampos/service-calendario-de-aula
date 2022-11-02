package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.AulaQueryRepository;

public abstract class QueryRepository implements RepositoryGatewayFactory{
	
	abstract AulaQueryRepository getAulaQueryRepository();

}
