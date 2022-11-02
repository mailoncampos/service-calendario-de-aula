package br.com.onlinecarlinda.servicecalendariodeaula.dominio.usecase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.aula.Aula;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.repository.command.AulaCommandRepository;

@Component
public class GerarCalendarioProximosDias {
	
	@Autowired
	private AulaCommandRepository aulaRepository;
	
	public void gerar(List<Aula> aulas, LocalDate data) {
		
		aulaRepository.gerarAulasDoDia(aulas, data);
		
	}

}