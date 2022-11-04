package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.vo;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.AndamentoAulaAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AulaAlunoVo {
	
	private Aula aula;
		
	private AndamentoAulaAluno andamentoAula;

}
