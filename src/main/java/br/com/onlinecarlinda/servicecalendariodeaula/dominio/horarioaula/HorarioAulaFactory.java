package br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula;

import java.time.LocalTime;

import org.springframework.stereotype.Component;


@Component
public class HorarioAulaFactory {

	private HorarioAula horarioAula;
	
	public HorarioAulaFactory cadastrarHorarioAula(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		this.horarioAula = new HorarioAula(horaInicio, horaFim, diaSemana);
		return this;
	}
	
	
	public HorarioAula criar(){
		return this.horarioAula;
	}
}
