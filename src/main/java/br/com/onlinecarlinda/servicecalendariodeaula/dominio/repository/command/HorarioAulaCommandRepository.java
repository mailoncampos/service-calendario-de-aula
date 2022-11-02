package br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command;

import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;

@Repository
public interface HorarioAulaCommandRepository {
	
	HorarioAula cadastrar(HorarioAula horarioAula);

}
