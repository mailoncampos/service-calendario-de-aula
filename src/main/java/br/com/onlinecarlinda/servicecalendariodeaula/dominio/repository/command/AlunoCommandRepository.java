package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;

@Repository("AlunoCommandRepository")
public interface AlunoCommandRepository {
	
	void adicionar(Aluno aluno);

}
