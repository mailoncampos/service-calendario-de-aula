package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import java.util.List;

import lombok.Getter;

@Getter
public class GradeHorarios {
	
	private String nome;
	
	private List<Horario> horarios;
		
	private EstadoGrade estadoGrade;
	
	public void criarGrade(String nomeGrade, String nomeModelo) {
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
