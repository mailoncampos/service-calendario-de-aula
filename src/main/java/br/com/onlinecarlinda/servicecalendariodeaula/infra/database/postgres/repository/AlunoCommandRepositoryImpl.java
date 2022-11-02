package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AlunoCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.AlunoCommand;

@Repository
public interface AlunoCommandRepositoryImpl extends JpaRepository<AlunoCommand, Long>, AlunoCommandRepository{

	default AlunoCommandRepository getAlunoCommandRepository() {
		return this;
	}
	
	@Override
	default void adicionar(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}
}
