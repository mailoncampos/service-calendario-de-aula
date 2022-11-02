package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalTime;

import lombok.Getter;

@Getter
public class HorarioAula {
	
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	public HorarioAula() {	
	}
	
	public HorarioAula criar(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		
		DiaSemana diaSemanaEnum = DiaSemana.valueOf(diaSemana);
		
		if(DiaSemana.DOMINGO.equals(diaSemanaEnum)) {
			throw new IllegalArgumentException("Não é permitido cadastrar um horário de aula no " + diaSemanaEnum.getDescricao());
		}
		
		if(horaInicio.isAfter(horaFim)) {
			throw new IllegalArgumentException("Hora de final deve ser posterior a hora inicial");
		}
		
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana.toString();
		
		return this;
	}
	

}
