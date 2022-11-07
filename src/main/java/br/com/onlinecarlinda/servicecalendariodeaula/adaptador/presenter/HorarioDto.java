package br.com.onlinecarlinda.servicecalendariodeaula.adaptador.presenter;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HorarioDto {
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaInicio;
	
	@JsonFormat(pattern = "hh:MM")
	private LocalTime horaConclusao;
	
	private String dia;
	
}
