package br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula;

import java.time.LocalTime;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.enuns.DiaSemanaEnum;
import lombok.Getter;

@Getter
public class HorarioAula {
	
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	public HorarioAula(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		
		DiaSemanaEnum diaSemanaEnum = DiaSemanaEnum.valueOf(diaSemana);
		
		if(DiaSemanaEnum.DOMINGO.equals(diaSemanaEnum)) {
			throw new IllegalArgumentException("Não é permitido cadastrar um horário de aula no " + diaSemanaEnum.getDescricao());
		}
		
		if(horaInicio.isAfter(horaFim)) {
			throw new IllegalArgumentException("Hora de final deve ser posterior a hora inicial");
		}
		
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana.toString();
		
	}
	
	public HorarioAula() {
		
	}
	

}
