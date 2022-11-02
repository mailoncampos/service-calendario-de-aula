package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HorarioAulaFromAulaDto {
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;

}
