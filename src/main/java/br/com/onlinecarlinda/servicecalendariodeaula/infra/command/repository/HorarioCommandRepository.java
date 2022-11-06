package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarioRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.HorarioModel;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.exception.CalendarioAulaException;

@Repository
public interface HorarioCommandRepository extends JpaRepository<HorarioModel, Long>, GradeHorarioRepository {
	
	
	@Override
	default void adicionarOuModificarHorario(Horario horario) {

		List<HorarioModel> horarios = verificaDisponibilidadeDoPeriodoParaCadastrar(
				horario.getHoraInicio(), horario.getHoraConclusao(), horario.getDia().toString());

		if (!horarios.isEmpty()) {
			throw new CalendarioAulaException("Já existe um horário cadastrado dentro do mesmo periodo");
		}

		save(new HorarioModel().adicionarHorario(horario));
	}
	
	@Override
	default GradeHorarios buscarGradeHorariosPorNome(String nome) {

		List<Horario> horarios = new ArrayList<>();
		
		List<HorarioModel> horariosModel = buscarHorariosModelPorNomeModeloHorario(nome);
		
		if(!horariosModel.isEmpty()) {
			horariosModel.stream().forEach((h) -> {
				horarios.add(h.parseModelToHorario());
			});
		}
		
		return null;
	}
	
	@Query("SELECT ha FROM HorarioModel ha WHERE ha.nomeModelo = :nome")
	List<HorarioModel> buscarHorariosModelPorNomeModeloHorario(String nome);

	@Query("SELECT ha FROM HorarioModel ha WHERE 1=1 "
			+ "AND ((:horaInicio BETWEEN ha.horaInicio AND ha.horaConclusao) OR (:horaConclusao BETWEEN ha.horaInicio AND ha.horaConclusao)) "
			+ "AND (:dia LIKE ha.dia )")
	List<HorarioModel> verificaDisponibilidadeDoPeriodoParaCadastrar(LocalTime horaInicio, LocalTime horaConclusao,
			String dia);

}
