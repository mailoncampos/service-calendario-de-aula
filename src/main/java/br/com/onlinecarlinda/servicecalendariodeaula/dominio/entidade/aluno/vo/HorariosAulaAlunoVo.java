package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.Horario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HorariosAulaAlunoVo {
	
	private Long idHorario;
	
	public List<HorariosAulaAlunoVo> validarHorariosDeAula(List<Horario> horariosAula){
		
		if (horariosAula == null || horariosAula.isEmpty()) {
			throw new RuntimeException("Um aluno deve ter obrigatoriamente ao menos um horário de aula");
		}
		
		if (horariosAula.size() > 4) {
			throw new RuntimeException("Não é permitido adicionar mais de quatro horários de aula para um aluno");
		}
		
		
		List<Long> idHorarios = new ArrayList<>();
		
		
		
		
		for(Horario auxHorarioAula : horariosAula) {
			
		}
		return null;
	}
	
}
