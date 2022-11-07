package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.Getter;

@Getter
public class GradeHorarios {
	
	private String nome;
	
	private List<Horario> horarios;
		
	private EstadoGrade estadoGrade;
	
	public void criarGrade(String nomeGrade,  List<Horario> horarios) {
		
		if(nomeGrade == null)
			throw new IllegalArgumentException("Nome da grade de horários não pode ser nulo");
		
		this.nome = nomeGrade;
		this.horarios = horarios;
		this.estadoGrade = EstadoGrade.EM_DESENVOLVIMENTO;
	}
	
	public void adicionarHorariosNaGrade() {
		
	}
	
	public void disponibilizarGrade(String nomeGrade) {
		this.estadoGrade = EstadoGrade.DISPONIVEL;
	}
	
	public void indisponibilizarGrade(String nomeGrade) {
		this.estadoGrade = EstadoGrade.INDISPONIVEL;
	}

}
