package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastraAulaPorDemandaDto {
	
	private LocalDate dataAula;
	
	private HorarioAulaFromAulaDto horarioAulaDto;
	
	private List<EstacaoEstudoFromAulaDto> estacoesDeEstudo;
	
	private List<AlunoFromAulaDto> alunosAgendados;
	
	private String statusAula;

}
