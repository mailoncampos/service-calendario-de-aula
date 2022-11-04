package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import lombok.Getter;

@Getter
public class BuscarAulaDto extends HorarioAulaBuscarAlunoDto{


	private LocalDate dataAula;
		
	private String statusAula;

//	private Map<String, String> estacoesDeEstudo;
	
//	private List<AlunoBuscarAulaDto> alunosAgendados;
	
	public BuscarAulaDto(LocalDate dataAula) {
		super();
		this.dataAula = dataAula;
	}
	
	public BuscarAulaDto(LocalTime horaInicio, LocalTime horaFim, String diaSemana) {
		super(horaInicio, horaFim, diaSemana);
	}
	
	public BuscarAulaDto(LocalTime horaInicio, LocalTime horaFim, String diaSemana, LocalDate dataAula,	String statusAula) {
		super(horaInicio, horaFim, diaSemana);
		this.dataAula = dataAula;
		this.statusAula = statusAula;
	}	
	
	public List<BuscarAulaDto> aulasDoDia(List<Aula> aulasDoDia){
		
		List<BuscarAulaDto> aulasDoDiaDto = new ArrayList<BuscarAulaDto>();
		
//		for(Aula auxAula : aulasDoDia) {
//			aulasDoDiaDto.add(new BuscarAulaDto(auxAula.getHorarioAula().getHoraInicio(), 
//					auxAula.getHorarioAula().getHoraFim(),  
//					auxAula.getHorarioAula().getDiaSemana(), 
//					auxAula.getDataAula(),
//					 auxAula.getStatusAula()										 
//					));
//		}
		
		return aulasDoDiaDto;
	}



	

	
	
	

}
