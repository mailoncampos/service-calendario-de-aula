package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import lombok.Getter;


@Getter
@Component
public class HorarioAulaFactory {

	private HorarioAula horarioAula;
	
	public HorarioAulaFactory cadastrarHorarioAula(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		this.horarioAula = new HorarioAula().criar(horaInicio, horaFim, diaSemana);
		return this;
	}
	
	
	public HorarioAula criar(){
		return this.horarioAula;
	}
}
