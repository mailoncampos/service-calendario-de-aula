package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.time.LocalTime;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.Dia;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.HorarioId;
import lombok.Getter;

@Getter
public class HorarioAula {
	
	private HorarioId idHorario;
	
	private LocalTime horaInicio;

	private LocalTime horaConclusao;

	private Dia dia;
	
	public void criarHorarioAula(Long idHorario, LocalTime horaInicio, LocalTime horaConclusao, String dia) {
		this.idHorario = new HorarioId(idHorario);
		this.horaInicio = horaInicio;
		this.horaConclusao = horaConclusao;
		this.dia = Dia.valueOf(dia);
	}
	
	public void alterarHorarioAula() {
		
	}

}
