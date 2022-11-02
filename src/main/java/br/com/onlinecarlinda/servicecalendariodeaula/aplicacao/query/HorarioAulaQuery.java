package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.HorarioAulaQueryRepository;

@Component
public class HorarioAulaQuery {

	@Autowired
	private HorarioAulaQueryRepository horarioAulaQueryRepository;

	public List<HorarioAula> buscarHorariosConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		return horarioAulaQueryRepository.buscarHorariosConcorrente(horaInicio, horaFim, diaSemana);
	}

}
