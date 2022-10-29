package br.com.onlinecarlinda.servicecalendariodeaula.infra.horarioaula;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.core.exception.HorarioAulaException;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAulaRepository;

@Repository
public interface HorarioAulaRepositoryJpa extends JpaRepository<HorarioAulaModel, Long>, HorarioAulaRepository{

	@Override
	default	void cadastrar(HorarioAula horarioAula) {
		
		List<HorarioAulaModel> horariosAulaConcorrentes = buscarHorarioAulaConcorrente(
					horarioAula.getHoraInicio(), 
					horarioAula.getHoraFim(), 
					horarioAula.getDiaSemana());
			
			if(!horariosAulaConcorrentes.isEmpty()){
				throw new HorarioAulaException("Já existe um horário de aula cadastrado para o mesmo periodo!"); 
			}
			
			HorarioAulaModel horarioAulaModel = new HorarioAulaModel();
			save(horarioAulaModel.criar(horarioAula));
	}
	
	@Query("SELECT ha FROM HorarioAulaModel ha WHERE ("
			+ "((ha.horaInicio BETWEEN :horaInicio AND :horaFim AND ha.horaInicio != :horaFim) "
			+ "OR (ha.horaFim BETWEEN :horaInicio AND :horaFim  AND ha.horaFim != :horaInicio) "
			+ "OR (ha.horaFim = :horaFim AND ha.horaInicio = :horaInicio)) "
			+ "AND ha.diaSemana LIKE :diaSemana)")
	List<HorarioAulaModel> buscarHorarioAulaConcorrente(LocalTime horaInicio, LocalTime horaFim, String diaSemana);
		
}

