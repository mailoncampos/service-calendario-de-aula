package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;

public interface AlunoCommandRepository {
	
	void adicionar(Aluno aluno);

}
