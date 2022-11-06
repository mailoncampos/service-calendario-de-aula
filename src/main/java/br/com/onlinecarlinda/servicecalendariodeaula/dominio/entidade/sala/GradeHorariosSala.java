package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorariosId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.HorarioId;
import lombok.Getter;

@Getter
public class GradeHorariosSala {
		
	private GradeHorariosId idGradeHorarario;
	
	private List<HorarioId> horariosSala = new ArrayList<>();
	
	public void cadastrarGradeHorariosJuntoASala(String idGradeHorarario, List<Long> idHorariosGradeHorarario) {
		
		if(idGradeHorarario == null)
			throw new IllegalArgumentException("É necessario informar o id da grade de horários");
		
		if(idHorariosGradeHorarario == null || idHorariosGradeHorarario.isEmpty())
			throw new IllegalArgumentException("É necessario contém ao menos um horário registrado na grade semanal");

		this.idGradeHorarario = new GradeHorariosId(idGradeHorarario);
		idHorariosGradeHorarario.stream().forEach((horario) -> {this.horariosSala.add(new HorarioId(horario));});		
	}
	
	public void adicionarHorarioAGradeHorarioDaSala(HorarioId idHorario) {
		/*
		 * verificar se é possivel add o novo horarios
		 */
		if (idHorario == null)
			throw new IllegalArgumentException("É necessario informar o id do horário");
		
		this.horariosSala.add(idHorario);
	}
	
	public void removerHorarioDaGradeHorarioDaSala(Long idHorario) {
		
	}
	


}
