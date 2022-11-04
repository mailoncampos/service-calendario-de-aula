package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade;

import java.time.LocalTime;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioAula {
	
	private Long idHorarioAula;
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String diaSemana;
	
	private Long modeloHorarioSemanal;
	
	
	public HorarioAula criar(LocalTime horaInicio, LocalTime horaFim, String diaSemana, Long modeloHorarioSemanal) {
				
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


	public HorarioAula parseObject(Object object) {
		
		HorarioAula horarioAula = (HorarioAula) object;
		return horarioAula;
	}
	

}
