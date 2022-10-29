package br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.cadastrar;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.onlinecarlinda.servicecalendariodeaula.aplicacao.dto.CadastrarHorarioAulaDto;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAulaFactory;
import br.com.onlinecarlinda.servicecalendariodeaula.dominio.horarioaula.HorarioAulaRepository;


public class CadastrarHorarioAula {
	
	private final HorarioAulaRepository horarioAulaRepository;
	
	@Autowired
	private HorarioAulaFactory horarioAulaFactory;
	
	public CadastrarHorarioAula(HorarioAulaRepository horarioAulaRepository) {
		this.horarioAulaRepository = horarioAulaRepository;
	}
	
	public void executa(CadastrarHorarioAulaDto horarioAulaDto) {
		
		horarioAulaFactory = new HorarioAulaFactory();
		
		horarioAulaFactory = horarioAulaFactory.cadastrarHorarioAula(horarioAulaDto.getHoraInicio(), horarioAulaDto.getHoraFim(), horarioAulaDto.getDiaSemana());
		horarioAulaRepository.cadastrar(horarioAulaFactory.criar());
	}
	
	

}
