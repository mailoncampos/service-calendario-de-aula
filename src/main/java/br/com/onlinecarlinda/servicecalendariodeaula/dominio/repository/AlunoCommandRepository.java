package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;

@Repository
public interface AlunoCommandRepository {
	
	void adicionar(Aluno aluno);

}
