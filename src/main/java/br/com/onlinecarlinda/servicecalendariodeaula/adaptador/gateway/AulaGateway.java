package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AulaRepository;
import lombok.Getter;

@Getter
@Component
public class AulaGateway {

	private Aula aula;
	
	@Autowired
	private AulaRepository aulaCommandRepository;
	

	
}
