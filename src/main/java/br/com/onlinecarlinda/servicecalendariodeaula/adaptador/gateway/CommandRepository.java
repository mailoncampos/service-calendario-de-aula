package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaRepository;

public abstract class CommandRepository implements RepositoryGatewayFactory{

	abstract AlunoCommandRepository getAlunoCommandRepository();
	
	abstract AulaRepository getAulaCommandRepository();

}
