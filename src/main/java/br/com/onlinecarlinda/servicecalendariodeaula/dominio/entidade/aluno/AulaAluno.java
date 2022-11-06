package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.AndamentoAulaAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.TipoAulaAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.AulaId;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AulaAluno {
	
	private AulaId idAula;
	
	private TipoAulaAluno tipoAula;
		
	private AndamentoAulaAluno andamentoAula;
	
	public void agendarAula(Long idAula, String tipoAula) {
		
		this.tipoAula = TipoAulaAluno.valueOf(tipoAula);
		this.andamentoAula = AndamentoAulaAluno.AGENDADA;
	}
	public void registrarFrequenciaDoAlunoNaAula() {
		
	}
	public void remarcarAula() {
		
	}
	public void cancelarAula() {
		
	}

}
