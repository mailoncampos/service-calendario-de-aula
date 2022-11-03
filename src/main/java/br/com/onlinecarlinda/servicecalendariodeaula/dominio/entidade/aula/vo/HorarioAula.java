package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo;

import java.time.LocalTime;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioAula {
	
	private Long id;
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	
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
