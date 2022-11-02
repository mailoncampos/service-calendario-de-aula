package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.AulaWrite;

@Repository
public interface AulaJpaWrite extends JpaRepository<AulaWrite, Long>, AulaCommandRepository{

	
	@Query("SELECT a FROM AulaWrite a WHERE a.dataAula = :data")
	List<AulaWrite> buscarAulasPorDataQuery(LocalDate data);
	
	@Override
	default void gerarAulasDoDia(List<Aula> aulasDia, LocalDate data) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	default void adicionarAlunoNaAula(Aluno aluno, Aula aula) {
		// TODO Auto-generated method stub
		
	}

}
