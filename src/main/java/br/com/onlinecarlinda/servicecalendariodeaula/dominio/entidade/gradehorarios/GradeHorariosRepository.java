package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.gradehorarios;

import org.springframework.stereotype.Repository;

@Repository
public interface GradeHorariosRepository {
	
	void adicionarOuModificarGradeHorarios(GradeHorarios gradeHorario);
		
//	void removerHorario(Long idHorario);
	
//	Horario buscarHorarioPorId(Long idHorario);
	
	GradeHorarios buscarGradeHorariosPorNome(String nome);

}
