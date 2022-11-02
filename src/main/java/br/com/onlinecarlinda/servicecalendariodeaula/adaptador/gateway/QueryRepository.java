package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaQueryRepository;

public interface QueryRepository extends RepositoryGatewayFactory{
	
	AulaQueryRepository getAulaQueryRepository();

}
