package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.context.ApplicationEvent;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.enuns.TipoEventoHorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import lombok.Getter;


@Getter
public class HorarioAulaCadastradoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	private UUID eventId = UUID.randomUUID();
	
	private LocalDateTime dataHoraEvento = LocalDateTime.now();
	
	private Long idHorarioAula;
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	private TipoEventoHorarioAula tipoEvento;
	
	public HorarioAulaCadastradoEvent(Object source ,HorarioAula horarioAula) {
		super(source);
		this.idHorarioAula = horarioAula.getId();
		this.horaInicio = horarioAula.getHoraInicio();
		this.horaFim = horarioAula.getHoraFim();
		this.diaSemana = horarioAula.getDiaSemana();
		this.tipoEvento = TipoEventoHorarioAula.CADASTRADO;
		
	}
	
	
//	public HorarioAulaPublisher(ApplicationEventPublisher publisher) {
//		this.publisher = publisher;
//	}
//	
//	public void publicarEvento(String name) {
//		publisher.publishEvent(null);
//	}

}
