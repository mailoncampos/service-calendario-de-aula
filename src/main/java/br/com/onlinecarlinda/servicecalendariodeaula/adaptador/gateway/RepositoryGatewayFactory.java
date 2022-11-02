package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

public interface RepositoryGatewayFactory {
	
	QueryRepository getQuery();
	
	CommandRepository getCommand();
		
}
