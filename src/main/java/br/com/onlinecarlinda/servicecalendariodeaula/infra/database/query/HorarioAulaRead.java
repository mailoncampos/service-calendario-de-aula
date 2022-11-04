package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.event.EventFactory;
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
	
	public HorarioAula criarHorarioAula() {
		return new HorarioAula(idHorarioAula ,horaInicio.toLocalTime(), horaFim.toLocalTime(), diaSemana, 1L);
	}
	
	public HorarioAulaRead criarHorarioAulaRead(EventFactory horarioAulaEvent) {
		HorarioAula horarioAula = (HorarioAula) horarioAulaEvent.getObject();
		
//		this.id = horarioAulaEvent.();
		this.tipoEvento =  horarioAulaEvent.getTipoEvento().toString();
		this.idHorarioAula = horarioAula.getIdHorarioAula();
		this.horaInicio = LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horarioAula.getHoraInicio().getHour(), horarioAula.getHoraInicio().getMinute()));
		this.horaFim =  LocalDateTime.of(LocalDate.of(2022, 11, 2), LocalTime.of(horarioAula.getHoraFim().getHour(), horarioAula.getHoraFim().getMinute()));
		this.diaSemana =  horarioAula.getDiaSemana();
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
