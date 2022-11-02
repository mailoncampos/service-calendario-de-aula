package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AulaBuilder extends Aula{
	
	public Aula cadastrar(LocalDate dataAula, LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		
		if(dataAula.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException(
					"A data informada deve ser posterior a de inicio dos cadastros: " 
					+ dataAula.format(DateTimeFormatter.ofPattern("dd / MM / yyyy")));
		}
		
		this.dataAula = dataAula;
		
		this.horarioAula = new HorarioAula().criar(horaInicio, horaFim, diaSemana);
				
		return this;
	}
	
	public Aula criar() {
		return this;
	}
		
}
