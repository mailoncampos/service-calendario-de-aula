package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.HorarioAulaQueryRepository;

public class HorarioAulaQuery {
	
	@Autowired
	private HorarioAulaQueryRepository horarioAulaQueryRepository;
	
	public List<HorarioAula> buscarHorariosPorData(LocalDate data) {
		return horarioAulaQueryRepository.buscarHorariosPorData(data);
	}

}
