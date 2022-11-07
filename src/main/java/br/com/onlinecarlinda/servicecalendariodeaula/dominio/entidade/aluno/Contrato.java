package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aluno.enuns.StatusContrato;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.horario.HorarioId;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Contrato {
	
	private String numrContrato;
	
	private LocalDate dataInicio;
	
	private StatusContrato statusContrato;

	private List<HorarioId> horarios = new ArrayList<>();
	
	public void criarContrato(String numrContrato, LocalDate dataInicio, List<HorarioId> horarios) {
		
		this.horarios = horarios;
		this.dataInicio = dataInicio;
		this.statusContrato = StatusContrato.VIGENTE;
	}
	
}




















//	
//	public List<Long> validarHorariosDeAula(List<Horario> horariosAula){
//		
//		if (horariosAula == null || horariosAula.isEmpty()) {
//			throw new RuntimeException("Um aluno deve ter obrigatoriamente ao menos um horário de aula");
//		}
//		
//		if (horariosAula.size() > 4) {
//			throw new RuntimeException("Não é permitido adicionar mais de quatro horários de aula para um aluno");
//		}		
//		
////		List<Long> idHorarios = new ArrayList<>();
////
////		for(Horario auxHorarioAula : horariosAula) {
////			
////		}
//		return null;
//	}