package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.command.aula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.HorarioAulaQuery;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.HorarioAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.enuns.SituacaoAula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaCommandRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaQueryRepository;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase.GerarCalendarioProximosDias;

@Component
public class GerarAulas{
	
	private final Long diasNoFuturo = 15L;
		
	private AulaCommandRepository aulaCommandRepository;
	
	private AulaQueryRepository aulaQueryRepository;
	
	private HorarioAulaQuery horarioAulaQuery;
	
	@Autowired
	private GerarCalendarioProximosDias gerarCalendarioProximosDias;
	
	public GerarAulas(AulaCommandRepository aulaCommandRepository, AulaQueryRepository aulaQueryRepository) {
		this.aulaCommandRepository = aulaCommandRepository;
		this.aulaQueryRepository = aulaQueryRepository;
	}
	
	
	public void executar() {
		
		List<LocalDate> diasSemAula = listarDiasSemAula();
		
		if(diasSemAula.isEmpty()) {
			return;
		}
		
		for(LocalDate auxDate : diasSemAula) {
			
			/*
			 * Verificar se a data não é um feriado
			 */
			
			
			List<Aula> aulas = new ArrayList<Aula>();
			
			List<HorarioAula> horariosAulaDoDia = horarioAulaQuery.buscarHorariosPorData(auxDate);			
			
			
			for(HorarioAula auxHorarioAula : horariosAulaDoDia){
				/*
				 * Buscar os alunos com aula marcada nesse horario
				 * 
				 * Buscar as estaçoes de aulas cadastradas no sistema
				 * 
				 */
				aulas.add(new Aula().criar(auxDate, auxHorarioAula, SituacaoAula.AGENDADA));
				
			}
			
			gerarCalendarioProximosDias.gerar(aulas, auxDate);
			
		}
		
		
	}
	
	
	

	private List<LocalDate> listarDiasSemAula(){
		
		Long diasNoFuturoLocal = diasNoFuturo;
			
		LocalDate dataAtual = LocalDate.now();
		
		LocalDate dataFutura = dataAtual.plusDays(diasNoFuturoLocal);
		
		List<LocalDate> listaDeDatasSemAula = new ArrayList<LocalDate>();
		
		List<Aula> aulasDoDia = aulaQueryRepository.buscarAulasPorData(dataFutura);
		
		while(aulasDoDia.isEmpty()){
			
			listaDeDatasSemAula.add(dataFutura);
			
			diasNoFuturoLocal --;
			dataFutura = dataAtual.plusDays(diasNoFuturoLocal);
			
			aulasDoDia = aulaQueryRepository.buscarAulasPorData(dataFutura);	
		};
		
		listaDeDatasSemAula.sort((a , b) -> a.compareTo(b));
		
		return listaDeDatasSemAula;
	}
}
