package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.SituacaoAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.vo.AulaAlunoVo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.vo.HorariosAulaAlunoVo;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.validation.CPF;
import lombok.Getter;

@Getter
public class Aluno {
	
	private String nome;
	
	private String usuario;
	
	private CPF cpf;
	
	private List<HorariosAulaAlunoVo> horariosAulavo;
	
	private List<AulaAlunoVo> aulas;
	
	private SituacaoAluno situacaoAluno;

	public Aluno(String nome, String usuario, String status) {
		
//		StatusAluno statusEnum =  StatusAluno.valueOf(status);
			
		this.nome = nome;
		this.usuario = usuario;
	}
	
	public Aluno(String usuario) {
	
		this.usuario = usuario;		
	}

	public Aluno() {
		super();
	}
	
	
}
