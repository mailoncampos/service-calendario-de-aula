package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AulaCommandRepository;

public abstract class CommandRepository implements RepositoryGatewayFactory{

	abstract AlunoCommandRepository getAlunoCommandRepository();
	
	abstract AulaCommandRepository getAulaCommandRepository();

}
