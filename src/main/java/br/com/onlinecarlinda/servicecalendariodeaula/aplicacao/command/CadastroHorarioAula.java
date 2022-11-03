package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaCadastradoEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.HorarioAulaQuery;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.HorarioAulaUserCase;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Component
public class CadastroHorarioAula extends HorarioAulaUserCase{
	
	@Autowired
	private ApplicationEventPublisher publisher;	
	
	ApplicationContext applicationContext;
	
	@Autowired
	private HorarioAulaQuery horarioAulaQuery;

	
	public HorarioAula executa(HorarioAula horarioAula) throws CalendarioAulaException {
		
		try {			
			horarioAula = cadastrar(horarioAula);
			publisher.publishEvent(new HorarioAulaCadastradoEvent(horarioAula, horarioAula));
		} catch (CalendarioAulaException e) {
			e.printStackTrace();
			return null;
		}finally {
			
		}
		
		return horarioAula;
	}
	
	

}
