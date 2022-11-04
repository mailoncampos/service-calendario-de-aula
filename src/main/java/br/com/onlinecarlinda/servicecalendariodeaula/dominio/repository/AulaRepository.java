package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;

@Repository
public interface AulaRepository {
	
	void agendarAulas(List<Aula> aulasDia);
		
	List<Aula> buscarAulasPorData(LocalDate data);

}
