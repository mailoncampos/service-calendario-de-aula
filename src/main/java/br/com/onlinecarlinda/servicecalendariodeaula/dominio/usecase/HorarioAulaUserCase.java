package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.HorarioAulaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event.HorarioAulaEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event.enuns.TipoEventoHorarioAula;

@Component
public class HorarioAulaUserCase {
	
	@Autowired
	private HorarioAulaRepository horarioAulaWrite;	
	
	private ApplicationEventPublisher publisher;
	
//	private EventFactory objectEvent;
		
	public void cadastrar(HorarioAula horarioAula){
		
		
		try {
			
			horarioAulaWrite.cadastrar(horarioAula);
			publisher.publishEvent( new HorarioAulaEvent(this, horarioAula, TipoEventoHorarioAula.CADASTRADO));
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
	}

}
