package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.AlunoId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.AndamentoAulaAluno;
import lombok.Getter;

@Getter
public class AlunoAula {
	
	private AlunoId idAluno;
	
	private AndamentoAulaAluno andamento;
	
	public void agendaAula() {
		
	}
	
	public void registrarFrequencia() {
		
	}
	
	public void cancelarAula() {
		
	}
	
	public void remarcarAula() {
		
	}

}
