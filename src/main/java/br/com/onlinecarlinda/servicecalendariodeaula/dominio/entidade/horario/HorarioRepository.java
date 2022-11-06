package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository {
	
	void adicionarOuModificarHorario(Horario horario);
		
//	void removerHorario(Long idHorario);
	
//	Horario buscarHorarioPorId(Long idHorario);
	
	List<Horario> buscarHorariosPorNomeModeloHorario(String nome);

}
