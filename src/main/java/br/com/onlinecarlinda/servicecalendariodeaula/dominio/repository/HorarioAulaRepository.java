package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;

@Repository
public interface HorarioAulaRepository {
	
	void cadastrar(HorarioAula horarioAula);

	List<HorarioAula> buscarHorariosAulaPorDiaSemanaEModelo(String dia, Long modelo);

}
