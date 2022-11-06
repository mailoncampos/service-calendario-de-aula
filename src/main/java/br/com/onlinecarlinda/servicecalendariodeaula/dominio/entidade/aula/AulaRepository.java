package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository {
	
	void adicionarOuModificarAula(Aula aula);

	List<Aula> buscarAulasPorAndamentoESala(String andamento ,Long idSala);
			

}
