package br.com.onlinecarlinda.servicecalendariodeaula.infra.query.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.infra.query.model.HorarioAulaRead;

@Repository
public interface HorarioAulaJpaRead extends MongoRepository<HorarioAulaRead, String>{
	
	
	List<HorarioAulaRead> findByDiaSemanaAndHoraInicioBetween(String diaSemana,LocalDateTime horaInicio, LocalDateTime horaFim);
	
	List<HorarioAulaRead> findByHoraInicio(LocalDateTime horaInicio);
	
	List<HorarioAulaRead> findByTipoEventoAndDiaSemana(String tipoEvento, String diaSemana);
	
	@Query("{ 'horaInicio' : { $gte: ?0, $lte: ?1 } }")
	List<HorarioAulaRead> readHorarioAulaConcorrente(LocalDateTime horaInicio, LocalDateTime horaFim);
}
