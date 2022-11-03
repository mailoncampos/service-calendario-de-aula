package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Repository
public interface HorarioAulaCommandRepository {
	
	HorarioAula cadastrar(HorarioAula horarioAula) throws CalendarioAulaException;

}
