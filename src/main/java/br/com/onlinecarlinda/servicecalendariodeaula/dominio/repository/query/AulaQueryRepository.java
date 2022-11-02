package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;

@Repository
public interface AulaQueryRepository {
	
	
	List<Aula> buscarAulasPorData(LocalDate data);


}
