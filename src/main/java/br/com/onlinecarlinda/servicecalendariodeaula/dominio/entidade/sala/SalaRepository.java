package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala;

import java.util.List;

public interface SalaRepository {
	
	void adicionarOuModificarSala(Sala sala);
	
	List<Sala> buscarTodas();


}
