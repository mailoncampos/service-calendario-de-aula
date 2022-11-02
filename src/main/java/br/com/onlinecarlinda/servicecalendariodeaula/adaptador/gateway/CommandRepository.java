package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaCommandRepository;

public interface CommandRepository extends RepositoryGatewayFactory{

	AlunoCommandRepository getAlunoCommandRepository();
	
	AulaCommandRepository getAulaCommandRepository();

}
