package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;

public interface AulaQueryRepository {
	
	List<Aula> buscarAulasPorData(LocalDate data);


}
