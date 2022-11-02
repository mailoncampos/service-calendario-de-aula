package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.dto;

import java.time.LocalTime;

import lombok.Getter;

@Getter
public abstract class HorarioAulaBuscarAlunoDto {
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;

	public HorarioAulaBuscarAlunoDto(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
	}
	
	public HorarioAulaBuscarAlunoDto() {
		super();
	}
		
}
