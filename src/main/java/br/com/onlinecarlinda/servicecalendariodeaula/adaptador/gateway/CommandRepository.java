package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AulaRepository;

public abstract class CommandRepository implements RepositoryGatewayFactory{

	abstract AlunoCommandRepository getAlunoCommandRepository();
	
	abstract AulaRepository getAulaCommandRepository();

}
