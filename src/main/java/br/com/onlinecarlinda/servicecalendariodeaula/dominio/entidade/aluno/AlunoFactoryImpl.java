package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import org.springframework.stereotype.Component;

@Component
public class AlunoFactoryImpl {
	
	private Aluno aluno;
	
	public AlunoFactoryImpl buscarAluno(String usuario) {
		this.aluno = new Aluno(usuario);
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}

}
