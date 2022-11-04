package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.command;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.HorarioAulaRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Repository
public interface HorarioAulaJpaWrite extends JpaRepository<HorarioAulaCommand, Long>, HorarioAulaRepository {

	default void cadastrar(HorarioAula horarioAula){
		
		if (!verificaDisponibilidadeDoPeriodoParaCadastrar(horarioAula.getHoraInicio(), horarioAula.getHoraFim(),
				horarioAula.getDiaSemana()).isEmpty()) {
			throw new CalendarioAulaException("Já existe um horário cadastrado dentro do mesmo periodo");
		}

		save(new HorarioAulaCommand().criar(horarioAula)).criarHorarioAula();
	}

	@Query("SELECT ha FROM HorarioAulaCommand ha WHERE 1=1 "
			+ "AND ((:horaInicio BETWEEN ha.horaInicio AND ha.horaFim) OR (:horaFim BETWEEN ha.horaInicio AND ha.horaFim)) "
			+ "AND (:diaSemana LIKE ha.diaSemana )")
	List<HorarioAulaCommand> verificaDisponibilidadeDoPeriodoParaCadastrar(LocalTime horaInicio, LocalTime horaFim,
			String diaSemana);
	
	
	@Override
	default List<HorarioAula> buscarHorariosAulaPorDiaSemanaEModelo(String dia, Long modelo) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Query();
//	List<HorarioAulaCommand> buscarHorariosAulaCommandPorDiaSemanaEModelo(String dia, Long modelo);
}
