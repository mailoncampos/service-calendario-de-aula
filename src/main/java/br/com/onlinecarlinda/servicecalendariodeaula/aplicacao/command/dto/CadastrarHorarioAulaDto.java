package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastrarHorarioAulaDto {
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaInicio;
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaFim;
	
	private String diaSemana;
	
//	public HorarioAula criarHorarioAula() {
//		return new HorarioAula(null, horaInicio, horaFim, diaSemana);
//	}
	
	public CadastrarHorarioAulaDto parseHorarioAula(HorarioAula horarioAula) {
		
		this.horaInicio = LocalTime.of(horarioAula.getHoraInicio().getHour(), horarioAula.getHoraInicio().getMinute());
		this.horaFim = LocalTime.of(horarioAula.getHoraFim().getHour(), horarioAula.getHoraFim().getMinute());
		this.diaSemana = horarioAula.getDiaSemana();
		return this;
	}
	
	
}
