package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.HorarioAulaUserCase;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Component
public class CadastroHorarioAula extends HorarioAulaUserCase{
	
	@Autowired
	private ApplicationEventPublisher publisher;	
		
	public void executa(HorarioAula horarioAula) throws CalendarioAulaException {
		
		
		
		return;
	}
	
	

}
