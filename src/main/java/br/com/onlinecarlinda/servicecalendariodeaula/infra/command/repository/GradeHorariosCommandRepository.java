package br.com.onlinecarlinda.servicecalendariodeaula.infra.command.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorariosRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.GradeHorarioModel;
import br.com.onlinecarlinda.servicecalendariodeaula.infra.command.model.HorarioModel;

//@Repository
public interface GradeHorariosCommandRepository extends JpaRepository<GradeHorarioModel, Long>, GradeHorariosRepository {
	
	
	@Override
	default void adicionarOuModificarGradeHorarios(GradeHorarios gradeHorarios) {
		save(new GradeHorarioModel().criarGradeHorarios(gradeHorarios));
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



}
