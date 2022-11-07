package br.com.onlinecarlinda.servicecalendariodeaula.infra.query.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.event.EventFactory;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@Getter
public class HorarioAulaRead {
	
	@Id
	private String id;
	
	private Long idHorarioAula;

	@JsonFormat(pattern = "HH:mm")
	private LocalDateTime horaInicio;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalDateTime horaFim;
	
	private String diaSemana;
	
	private String tipoEvento;
	
	
	public HorarioAulaRead criarHorarioAulaRead(EventFactory horarioAulaEvent) {
		Horario horarioAula = (Horario) horarioAulaEvent.getObject();
		
//		this.id = horarioAulaEvent.();
		this.tipoEvento =  horarioAulaEvent.getTipoEvento().toString();
		this.idHorarioAula = horarioAula.getIdHorario();
		this.horaInicio = LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horarioAula.getHoraInicio().getHour(), horarioAula.getHoraInicio().getMinute()));
		this.horaFim =  LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horarioAula.getHoraConclusao().getHour(), horarioAula.getHoraConclusao().getMinute()));
		this.diaSemana =  horarioAula.getDia().toString();
		return this;
	}

	public HorarioAulaRead(String id, Long idHorarioAula, LocalDateTime horaInicio, LocalDateTime horaFim,
			String diaSemana, String tipoEvento) {
		super();
		this.id = id;
		this.idHorarioAula = idHorarioAula;
		this.horaInicio = LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horaInicio.getHour(), horaInicio.getMinute()));
		this.horaFim =  LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horaFim.getHour(), horaFim.getMinute()));
		this.diaSemana = diaSemana;
		this.tipoEvento = tipoEvento;
	}

}
