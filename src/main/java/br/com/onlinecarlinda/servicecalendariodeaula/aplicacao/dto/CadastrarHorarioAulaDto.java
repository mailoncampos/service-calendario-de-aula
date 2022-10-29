package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAula;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastrarHorarioAulaDto {
	
	@JsonFormat(pattern = "hh:MM", timezone = "America/Cuiaba")
	private LocalTime horaInicio;
	
	@JsonFormat(pattern = "hh:MM", timezone = "America/Cuiaba")
	private LocalTime horaFim;
	
	private String diaSemana;
	
	public HorarioAula criarHorarioAula() {
		return new HorarioAula(horaInicio, horaFim, diaSemana);
	}

}
