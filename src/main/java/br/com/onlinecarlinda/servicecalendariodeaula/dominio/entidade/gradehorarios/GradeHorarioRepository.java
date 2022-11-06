package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import org.springframework.stereotype.Repository;

@Repository
public interface GradeHorarioRepository {
	
	void adicionarOuModificarHorario(Horario horario);
		
//	void removerHorario(Long idHorario);
	
//	Horario buscarHorarioPorId(Long idHorario);
	
	GradeHorarios buscarGradeHorariosPorNome(String nome);

}
