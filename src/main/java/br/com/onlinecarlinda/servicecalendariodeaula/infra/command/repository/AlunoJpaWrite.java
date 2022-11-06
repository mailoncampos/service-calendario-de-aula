package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.AlunoModel;

@Repository
public interface AlunoJpaWrite extends JpaRepository<AlunoModel, Long>, AlunoCommandRepository{

	default AlunoCommandRepository getAlunoCommandRepository() {
		return this;
	}
	
	@Override
	default void adicionar(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}
}
