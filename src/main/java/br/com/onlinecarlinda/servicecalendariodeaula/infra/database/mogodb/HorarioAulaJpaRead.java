package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.vo.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.query.HorarioAulaQueryRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.mogodb.model.HorarioAulaRead;

@Repository
public interface HorarioAulaJpaRead extends MongoRepository<HorarioAulaRead, String>, HorarioAulaQueryRepository{
	
	@Override
	default List<HorarioAula> buscarHorariosConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		List<HorarioAulaRead> horariosRead = readHorarioAulaConcorrente(LocalTime.now(), LocalTime.now(), "SEGUNDA");
		
		List<HorarioAula> horarios = new ArrayList<HorarioAula>();
		for(HorarioAulaRead auxHorarioAula : horariosRead) {			
			horarios.add(auxHorarioAula.criarHorarioAula());
		}
		return horarios;
	}
	
	@Query("SELECT ha FROM HorarioAulaRead ha WHERE ("
			+ "((ha.horaInicio BETWEEN :horaInicio AND :horaFim AND ha.horaInicio != :horaFim) "
			+ "OR (ha.horaFim BETWEEN :horaInicio AND :horaFim  AND ha.horaFim != :horaInicio) "
			+ "OR (ha.horaFim = :horaFim AND ha.horaInicio = :horaInicio)) "
			+ "AND ha.diaSemana LIKE :diaSemana)")
	List<HorarioAulaRead> readHorarioAulaConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana);
}
