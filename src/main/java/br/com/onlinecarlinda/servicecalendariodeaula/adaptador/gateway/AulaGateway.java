package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.AulaQueryRepository;
import lombok.Getter;

@Getter
@Component
public class AulaGateway {

	private Aula aula;
	
	@Autowired
	private AulaCommandRepository aulaCommandRepository;
	
	@Autowired
	private AulaQueryRepository aulaQueryRepository;
	
}
