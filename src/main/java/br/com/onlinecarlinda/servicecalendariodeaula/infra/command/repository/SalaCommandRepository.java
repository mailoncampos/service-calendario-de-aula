package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.Sala;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.sala.SalaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.SalaModel;

@Repository
public interface SalaCommandRepository extends JpaRepository<SalaModel, Long>, SalaRepository{

	@Override
	default void adicionarOuModificarSala(Sala sala) {		
		
		
		save(new SalaModel().cadastrarSala(sala));
	}
	
	@Override
	default List<Sala> buscarTodas() {
		
		List<Sala> salas = new ArrayList<>();

		List<SalaModel> salasModel = findAll();
		
	
		
		return salas;
	}
}
