package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaCadastradoEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.HorarioAulaQuery;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.HorarioAulaUserCase;

@Component
public class CadastroHorarioAula extends HorarioAulaUserCase{
	
	@Autowired
	private ApplicationEventPublisher publisher;	
	
	ApplicationContext applicationContext;
	
	@Autowired
	private HorarioAulaQuery horarioAulaQuery;

	
	public void executa(HorarioAula horarioAula) throws Exception {
		
		List<HorarioAula> horariosConcorrentes = horarioAulaQuery.buscarHorariosConcorrente(horarioAula.getHoraInicio(), horarioAula.getHoraFim(), horarioAula.getDiaSemana());
		
		if(!horariosConcorrentes.isEmpty()) {
			throw new Exception();
		}
		
		horarioAula = cadastrar(horarioAula);
		
		publisher.publishEvent(new HorarioAulaCadastradoEvent(horariosConcorrentes, horarioAula));
//		eventFactory.getEventFactory(applicationContext);

	}
	
	

}
