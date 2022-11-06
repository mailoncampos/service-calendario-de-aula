package br.com.onlinecarlinda.servicecalendariodeaula.dominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarioRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.GradeHorarios;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios.Horario;

@Service
public class GradeHorarioService {

	@Autowired
	private GradeHorarioRepository gradeHorarioRepository;

	public void adicionarHorario(Horario horario) {
		gradeHorarioRepository.adicionarOuModificarHorario(horario.adicionarHorario(horario.getHoraInicio(),
				horario.getHoraConclusao(), horario.getDia().getDescricao()));
	}

	public GradeHorarios buscarGradeHorariosPorNome(String nome) {
		return gradeHorarioRepository.buscarGradeHorariosPorNome(nome);
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
