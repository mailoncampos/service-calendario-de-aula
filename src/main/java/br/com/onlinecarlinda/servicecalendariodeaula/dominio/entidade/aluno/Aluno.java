package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.SituacaoAluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.HorarioId;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.vo.CPF;
import lombok.Getter;

@Getter
public class Aluno {
	
	private String nome;
		
	private CPF cpf;
	
	private List<Contrato> contratos = new ArrayList<>();
	
	private List<AulaAluno> aulas = new ArrayList<>();

	private List<HorarioId> horarios = new ArrayList<>();
	
	private SituacaoAluno situacaoAluno;
	
	public void registrarAlunoMatriculado(String nome, String cpf, Contrato contrato) {
		
		if(this.horarios.isEmpty())
			this.horarios = contrato.getHorarios();
		
		this.nome = nome;
		this.cpf = new CPF().stringToCpfValido(cpf);
//		this.contratos
//		this.aulas
//		this.situacaoAluno
	}
	
	public void concluirContrato() {
		
	}
	
	
}
