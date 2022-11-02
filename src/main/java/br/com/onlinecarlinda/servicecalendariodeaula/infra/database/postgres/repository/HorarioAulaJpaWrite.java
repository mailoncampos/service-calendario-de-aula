package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.HorarioAulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.HorarioAulaWrite;

@Repository
public interface HorarioAulaJpaWrite extends JpaRepository<HorarioAulaWrite, Long>, HorarioAulaCommandRepository{

	
	default	HorarioAula cadastrar(HorarioAula horarioAula) {
			return save(new HorarioAulaWrite().criar(horarioAula)).criarHorarioAula();
	}		
}

