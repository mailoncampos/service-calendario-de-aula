package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;

@Repository
public interface HorarioAulaQueryRepository {

	List<HorarioAula> buscarHorariosConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana);

}
