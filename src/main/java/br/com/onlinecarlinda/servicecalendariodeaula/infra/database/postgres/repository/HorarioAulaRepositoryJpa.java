package br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAulaFactory;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.database.postgres.model.HorarioAulaModel;

@Repository
public interface HorarioAulaRepositoryJpa extends JpaRepository<HorarioAulaModel, Long>{

	
	default	void cadastrar(HorarioAulaFactory horarioAulaFactory) {
		
		List<HorarioAulaModel> horariosAulaConcorrentes = buscarHorarioAulaConcorrente(
				horarioAulaFactory.getHorarioAula().getHoraInicio(), 
				horarioAulaFactory.getHorarioAula().getHoraFim(), 
				horarioAulaFactory.getHorarioAula().getDiaSemana());
			
			if(!horariosAulaConcorrentes.isEmpty()){
			}
			
			HorarioAulaModel horarioAulaModel = new HorarioAulaModel(horarioAulaFactory);
			save(horarioAulaModel);
	}
	
	@Query("SELECT ha FROM HorarioAulaModel ha WHERE ("
			+ "((ha.horaInicio BETWEEN :horaInicio AND :horaFim AND ha.horaInicio != :horaFim) "
			+ "OR (ha.horaFim BETWEEN :horaInicio AND :horaFim  AND ha.horaFim != :horaInicio) "
			+ "OR (ha.horaFim = :horaFim AND ha.horaInicio = :horaInicio)) "
			+ "AND ha.diaSemana LIKE :diaSemana)")
	List<HorarioAulaModel> buscarHorarioAulaConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana);
		
}

