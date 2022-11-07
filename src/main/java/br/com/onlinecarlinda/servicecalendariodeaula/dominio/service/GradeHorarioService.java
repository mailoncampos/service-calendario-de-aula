package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorariosRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;

@Service
public class GradeHorarioService {

	@Autowired
	private GradeHorariosRepository gradeHorariosRepository;

	public void criarGradeHorario(String nomeGradeHorario, List<Horario> horarios) {
		
		GradeHorarios grade = gradeHorariosRepository.buscarGradeHorariosPorNome(nomeGradeHorario);
		
		if(grade != null)
			throw new IllegalArgumentException("Nome da grade de horários já existe!");
		
		grade = new GradeHorarios();
		

		if(horarios != null && !horarios.isEmpty()) {
			
			/*
			 * Validar Horarios recebidos
			 */
		}
			
		grade.criarGrade(nomeGradeHorario, horarios);
		gradeHorariosRepository.adicionarOuModificarGradeHorarios(grade);
	}

	public GradeHorarios buscarGradeHorariosPorNome(String nome) {
		return gradeHorariosRepository.buscarGradeHorariosPorNome(nome);
	}

}

//		try {
//			
//			horarioAulaWrite.adicionarOuModificarHorario(horarioAula);
//			publisher.publishEvent( new HorarioAulaEvent(this, horarioAula, TipoEventoHorarioAula.CADASTRADO));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			
//		}
//		
//	}
