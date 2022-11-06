package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import org.springframework.stereotype.Repository;

@Repository
public interface AlunoCommandRepository {
	
	void adicionar(Aluno aluno);

}
