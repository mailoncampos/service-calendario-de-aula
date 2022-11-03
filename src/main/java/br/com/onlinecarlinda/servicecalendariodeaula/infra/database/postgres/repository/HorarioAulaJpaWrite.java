package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.HorarioAulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.HorarioAulaWrite;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Repository
public interface HorarioAulaJpaWrite extends JpaRepository<HorarioAulaWrite, Long>, HorarioAulaCommandRepository {

	default HorarioAula cadastrar(HorarioAula horarioAula) throws CalendarioAulaException {
		
		if (!verificaDisponibilidadeDoPeriodoParaCadastrar(horarioAula.getHoraInicio(), horarioAula.getHoraFim(),
				horarioAula.getDiaSemana()).isEmpty()) {
			throw new CalendarioAulaException("Já existe um horário cadastrado dentro do mesmo periodo");
		}

		return save(new HorarioAulaWrite().criar(horarioAula)).criarHorarioAula();
	}

	@Query("SELECT ha FROM HorarioAulaWrite ha WHERE 1=1 "
			+ "AND ((:horaInicio BETWEEN ha.horaInicio AND ha.horaFim) OR (:horaFim BETWEEN ha.horaInicio AND ha.horaFim)) "
			+ "AND (:diaSemana LIKE ha.diaSemana )")
	List<HorarioAulaWrite> verificaDisponibilidadeDoPeriodoParaCadastrar(LocalTime horaInicio, LocalTime horaFim,
			String diaSemana);
}
