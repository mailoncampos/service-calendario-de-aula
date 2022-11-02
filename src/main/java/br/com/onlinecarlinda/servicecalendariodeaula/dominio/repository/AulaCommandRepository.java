package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.Aluno;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;

@Repository("AulaRepositoryDominio")
public interface AulaCommandRepository {
	
	void gerarAulasDoDia(List<Aula> aulasDia, LocalDate data);
	
	void adicionarAlunoNaAula(Aluno aluno, Aula aula);

}
