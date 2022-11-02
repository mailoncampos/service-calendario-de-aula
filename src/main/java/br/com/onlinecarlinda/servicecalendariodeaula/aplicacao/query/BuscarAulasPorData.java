package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query;

import java.time.LocalDate;
import java.util.List;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.query.dto.BuscarAulaDto;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.AulaQueryRepository;

public class BuscarAulasPorData {
	
	private final AulaQueryRepository aulaQueryRepository;
	
	public BuscarAulasPorData(AulaQueryRepository aulaRepository) {
		this.aulaQueryRepository = aulaRepository;
	}
	
	public List<BuscarAulaDto> executa(LocalDate data) {
		
		
		
		
//		aulaFactory = aulaFactory.buscarAulasPorData(data);
		
//		aulaFactory.getAulasDoDia()
//		List<BuscarAulaDto> aulasDoDia = buscarAulaDto.aulasDoDia(aulaRepository.buscarAulasPorData(aulaFactory));
		
		
		return null;
	}
	
	

}
