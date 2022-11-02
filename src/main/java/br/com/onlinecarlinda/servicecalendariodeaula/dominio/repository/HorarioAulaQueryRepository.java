package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAula;

public interface HorarioAulaQueryRepository {

	List<HorarioAula> buscarHorariosPorData(LocalDate data);

}
