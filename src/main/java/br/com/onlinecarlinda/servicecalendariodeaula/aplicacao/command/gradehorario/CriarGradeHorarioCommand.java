package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.gradehorario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.HorarioAulaEvent;
import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.TipoEventoHorario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.service.GradeHorarioService;

@Service
public class CriarGradeHorarioCommand{
	
	@Autowired
	private GradeHorarioService horarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	public HttpStatus executa(String nomeGradeHorario, List<Horario> horarios) {
		
		try {

			horarioService.criarGradeHorario(nomeGradeHorario, horarios);
			
			HorarioAulaEvent event = new HorarioAulaEvent(this, horarios, TipoEventoHorario.ADICIONADO, "Cadastrado");
			
			
			publisher.publishEvent(event);
			return HttpStatus.CREATED;
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			
			HorarioAulaEvent event = new HorarioAulaEvent(this, horarios, TipoEventoHorario.ERRO, e.getMessage());
			publisher.publishEvent(event);
			return HttpStatus.INTERNAL_SERVER_ERROR;
			
		}
		
		
	}

//	public Horario horario;
//	
//	public AdicionarHorarioCommand(Horario horario) {
//		this.horario = horario;
//	}	
}
